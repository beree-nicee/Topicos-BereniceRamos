package ejemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidadorTest {
    Validador validador = new Validador();

    @Test
    public void pruebaMayorDeEdad() {
        assertTrue(validador.esMayorDeEdad(20), "20 años debería ser mayor de edad");

    }

    @Test
    public void pruebaMenorDeEdad() {
        assertFalse(validador.esMayorDeEdad(15), "15 años es menor de edad");
    }

    @Test
    public void pruebaCasoLimite() {
        assertTrue(validador.esMayorDeEdad(18), "18 ya es mayor de edad ");
    }
}


