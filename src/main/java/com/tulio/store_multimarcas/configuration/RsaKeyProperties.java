package com.tulio.store_multimarcas.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class RsaKeyProperties {

    private String publicKey;
    private String privateKey;
}
