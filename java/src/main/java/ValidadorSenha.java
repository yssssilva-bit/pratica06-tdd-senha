import java.util.ArrayList;
import java.util.List;

public class ValidadorSenha {

    public static class ResultadoValidacao {
        private boolean valida;
        private List<String> erros;

        public ResultadoValidacao(boolean valida, List<String> erros) {
            this.valida = valida;
            this.erros = erros;
        }

        public boolean isValida() {
            return valida;
        }

        public List<String> getErros() {
            return erros;
        }
    }

    public static ResultadoValidacao validarSenha(String senha) {
        List<String> erros = new ArrayList<>();

        if (senha == null || senha.length() < 8) {
            erros.add("A senha deve ter pelo menos 8 caracteres");
        }

        long digitos = senha != null ? senha.chars().filter(Character::isDigit).count() : 0;
        if (digitos < 2) {
            erros.add("A senha deve conter pelo menos 2 dígitos");
        }

        boolean temMaiuscula = senha != null && senha.chars().anyMatch(Character::isUpperCase);
        if (!temMaiuscula) {
            erros.add("A senha deve conter pelo menos uma letra maiúscula");
        }

        boolean temEspecial = senha != null && senha.chars().anyMatch(c -> !Character.isLetterOrDigit(c));
        if (!temEspecial) {
            erros.add("A senha deve conter pelo menos um caractere especial");
        }

        return new ResultadoValidacao(erros.isEmpty(), erros);
    }
}