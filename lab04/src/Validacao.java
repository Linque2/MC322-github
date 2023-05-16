public class Validacao {
        
    public static boolean sequenciaDeAlgarismosIguais(String string) {
        boolean mesmo_algarismo = true;
        for (int i = 0; i < 10; i++){
            if (string.charAt(i) != string.charAt(i + 1))
                mesmo_algarismo = false;
        }
        return mesmo_algarismo;
    }
    
    public static boolean validarCPF(String cpf){
            String cpfNumérico;
            cpfNumérico = cpf.replaceAll("[^\\d]", "");             //Remove todos os caracteres não numéricos da string
    
            if (cpfNumérico.length() != 11)                         //Verifica se o cpf possui 11 caracteres numéricos
                return false;
    
            if (sequenciaDeAlgarismosIguais(cpfNumérico) == true)   //Verifica se todos os dígitos do cpf são iguais
                return false;
    
            if (Integer.parseInt(cpfNumérico.substring(9, 11)) != Integer.parseInt(calcularDigitosVerificadoresDoCPF(cpfNumérico)))
                return false;
    
            return true;
        }
    
        public static String calcularDigitosVerificadoresDoCPF(String cpf) {
            int digVer1 = 0, digVer2 = 0;
            String DV;
            for (int i = 0; i < 9; i++) {
                int alg = cpf.charAt(i) - 48;
                digVer1 += alg * (10 - i);
            }
            digVer1 = 11 - digVer1 % 11;
            if (digVer1 > 9)
                digVer1 = 0;
    
            for (int i = 1; i < 9; i++) {
                int alg = cpf.charAt(i) - 48;
                digVer2 +=  alg * (10 - (i - 1));
            }
            digVer2 += digVer1 * 2;
            digVer2 = 11 - digVer2 % 11;
            if (digVer2 > 9)
                digVer2 = 0;
    
            DV = Integer.toString(digVer1) + Integer.toString(digVer2);  
            return DV;
        }

        public static boolean validarCNPJ(String cpf){
            String cnpjNumérico;
            cnpjNumérico = cpf.replaceAll("[^\\d]", "");             //Remove todos os caracteres não numéricos da string
    
            if (cnpjNumérico.length() != 14)                         //Verifica se o cpf possui 11 caracteres numéricos
                return false;
    
            if (sequenciaDeAlgarismosIguais(cnpjNumérico) == true)   //Verifica se todos os dígitos do cpf são iguais
                return false;
    
            if (Integer.parseInt(cnpjNumérico.substring(12, 14)) != Integer.parseInt(calcularDigitosVerificadoresDoCNPJ(cnpjNumérico)))
                return false;
    
            return true;
        }
    
        public static String calcularDigitosVerificadoresDoCNPJ(String cpf) {
            int digVer1 = 0, digVer2 = 0;
            String DV;
            for (int i = 0; i < 12; i++) {
                int alg = cpf.charAt(i) - 48;
                if (i < 4)
                    digVer1 += alg * (5 - i);
                else
                    digVer1 += alg * (13 - i);
            }
            digVer1 = 11 - digVer1 % 11;
            if (digVer1 > 9)
                digVer1 = 0;
    
            for (int i = 0; i < 13; i++) {
                int alg = cpf.charAt(i) - 48;
                if (i < 5)
                    digVer2 += alg * (6 - i);
                else
                    digVer2 += alg * (14 - i);
            }
            digVer2 = 11 - digVer2 % 11;
            if (digVer2 > 9)
                digVer2 = 0;
    
            DV = Integer.toString(digVer1) + Integer.toString(digVer2);  
            return DV;
        }

        public static boolean validarNome(String nome) {
            for (int i = 0; i < nome.length(); i++) {
                if (nome.charAt(i) < 65 || (nome.charAt(i) > 90 && nome.charAt(i) < 95) || nome.charAt(i) > 122)
                    return false;
            }
            return true;
        }
}
