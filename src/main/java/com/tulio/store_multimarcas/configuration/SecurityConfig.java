package com.tulio.store_multimarcas.configuration;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(RsaKeyProperties.class)
public class SecurityConfig {

    private final RsaKeyProperties rsaKeyProperties;

    public SecurityConfig(RsaKeyProperties rsaKeyProperties) {
        this.rsaKeyProperties = rsaKeyProperties;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/authenticate").permitAll()
                        .requestMatchers("/user/all").hasAuthority("ADMIN")
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    JwtDecoder jwtDecoder() throws Exception {
        RSAPublicKey publicKey = loadPublicKey();
        return NimbusJwtDecoder.withPublicKey(publicKey).build();
    }

    @Bean
    JwtEncoder jwtEncoder() throws Exception {
        RSAPublicKey publicKey = loadPublicKey();
        RSAPrivateKey privateKey = loadPrivateKey();

        RSAKey rsaKey = new RSAKey.Builder(publicKey)
                .privateKey(privateKey)
                .build();
        JWKSet jwkSet = new JWKSet(rsaKey);
        JWKSource<SecurityContext> jwkSource = new ImmutableJWKSet<>(jwkSet);
        return new NimbusJwtEncoder(jwkSource);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        grantedAuthoritiesConverter.setAuthorityPrefix("");
        grantedAuthoritiesConverter.setAuthoritiesClaimName("scope");

        JwtAuthenticationConverter authConverter = new JwtAuthenticationConverter();
        authConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        return authConverter;
    }

    private RSAPublicKey loadPublicKey() throws Exception {
        String publicKeyContent = getKeyContent(rsaKeyProperties.getPublicKey());
        return parsePublicKey(publicKeyContent);
    }

    private RSAPrivateKey loadPrivateKey() throws Exception {
        String privateKeyContent = getKeyContent(rsaKeyProperties.getPrivateKey());
        return parsePrivateKey(privateKeyContent);
    }

    private String getKeyContent(String keySource) throws Exception {
        if (keySource.startsWith("classpath:")) {
            // Desenvolvimento local - lê do classpath
            String resourcePath = keySource.replace("classpath:", "");
            try (InputStream inputStream = new ClassPathResource(resourcePath).getInputStream()) {
                return new String(inputStream.readAllBytes());
            }
        } else {
            // Produção - já é o conteúdo da chave
            return keySource;
        }
    }

    private RSAPublicKey parsePublicKey(String publicKeyContent) throws Exception {
        publicKeyContent = publicKeyContent
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\r\\n|\\r|\\n", "")
                .replaceAll("\\s+", "");

        byte[] keyBytes = Base64.getDecoder().decode(publicKeyContent);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return (RSAPublicKey) keyFactory.generatePublic(spec);
    }

    private RSAPrivateKey parsePrivateKey(String privateKeyContent) throws Exception {
        privateKeyContent = privateKeyContent
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\r\\n|\\r|\\n", "")
                .replaceAll("\\s+", "");

        byte[] keyBytes = Base64.getDecoder().decode(privateKeyContent);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return (RSAPrivateKey) keyFactory.generatePrivate(spec);
    }
}