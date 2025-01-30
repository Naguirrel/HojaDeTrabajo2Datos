package uvg;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la clase CalculadoraPostfix.
 */
public class CalculadoraPostfixTest {
    private CalculadoraPostfix calculadora;

    /**
     * Configuración inicial antes de cada prueba.
     */
    @BeforeEach
    void setUp() {
        calculadora = new CalculadoraPostfix();
    }

    /**
     * Prueba para evaluar una expresión válida en notación Postfix.
     */
    @Test
    void testEvaluarExpresionValida() {
        String expresion = "3 4 + 2 *";
        int resultado = calculadora.evaluar(expresion);
        assertEquals(14, resultado, "El resultado de la expresión debe ser 14.");
    }

    /**
     * Prueba para verificar que una expresión inválida lanza una excepción.
     */
    @Test
    void testEvaluarExpresionInvalida() {
        String expresion = "3 +";
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            calculadora.evaluar(expresion);
        });
        assertEquals("Expresión inválida: faltan operandos.", exception.getMessage());
    }

    /**
     * Prueba para verificar que la división por cero lanza una excepción.
     */
    @Test
    void testDivisionPorCero() {
        String expresion = "10 0 /";
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculadora.evaluar(expresion);
        });
        assertEquals("Error: División por cero.", exception.getMessage());
    }
}
