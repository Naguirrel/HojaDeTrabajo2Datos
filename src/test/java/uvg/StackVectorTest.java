package uvg;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackVectorTest {
    private StackVector<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new StackVector<>();
    }

    @Test
    void testPushAndSize() {
        stack.push(5);
        stack.push(10);
        assertEquals(2, stack.size(), "El tamaño de la pila debe ser 2 después de dos inserciones.");
    }

    @Test
    void testPop() {
        stack.push(7);
        stack.push(3);
        assertEquals(3, stack.pop(), "Debe retornar el último elemento insertado.");
        assertEquals(1, stack.size(), "El tamaño de la pila debe ser 1 después de un pop.");
    }

    @Test
    void testPeek() {
        stack.push(42);
        assertEquals(42, stack.peek(), "Debe retornar el último elemento sin eliminarlo.");
        assertEquals(1, stack.size(), "El tamaño de la pila debe seguir siendo 1 después de un peek.");
    }

    @Test
    void testEmpty() {
        assertTrue(stack.empty(), "La pila debe estar vacía al inicio.");
        stack.push(9);
        assertFalse(stack.empty(), "La pila no debe estar vacía después de un push.");
        stack.pop();
        assertTrue(stack.empty(), "La pila debe estar vacía después de eliminar todos los elementos.");
    }
}