import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidadorSenhaTest {

    @Test
    void testSenhaValida() {
        ValidadorSenha.ResultadoValidacao resultado = ValidadorSenha.validarSenha("SenhaSegura123!");
        assertTrue(resultado.isValida());
        assertTrue(resultado.getErros().isEmpty());
    }

    @Test
    void testSenhaCurta() {
        ValidadorSenha.ResultadoValidacao resultado = ValidadorSenha.validarSenha("Ab1!");
        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains("A senha deve ter pelo menos 8 caracteres"));
    }

    @Test
    void testPoucosDigitos() {
        ValidadorSenha.ResultadoValidacao resultado = ValidadorSenha.validarSenha("SenhaForte!");
        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains("A senha deve conter pelo menos 2 dígitos"));
    }

    @Test
    void testSemMaiuscula() {
        ValidadorSenha.ResultadoValidacao resultado = ValidadorSenha.validarSenha("senhaforte123!");
        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains("A senha deve conter pelo menos uma letra maiúscula"));
    }

    @Test
    void testSemCaractereEspecial() {
        ValidadorSenha.ResultadoValidacao resultado = ValidadorSenha.validarSenha("SenhaForte123");
        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains("A senha deve conter pelo menos um caractere especial"));
    }
}