package com.tulio.store_multimarcas.client.util.validate;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidateCnpj {

    public static boolean validar(String cnpj) {
        cnpj = cnpj.replaceAll("\\D", "");

        if (cnpj.length() != 14) {
            return false;
        }

        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        int digito1 = calcularDigito(cnpj.substring(0, 12));

        int digito2 = calcularDigito(cnpj.substring(0, 12) + digito1);

        return cnpj.equals(cnpj.substring(0, 12) + digito1 + digito2);
    }

    private static int calcularDigito(String str) {
        int peso = 2;
        int soma = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            int numero = Character.getNumericValue(str.charAt(i));
            soma += numero * peso;
            peso = (peso == 9) ? 2 : peso + 1;
        }

        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }
}
