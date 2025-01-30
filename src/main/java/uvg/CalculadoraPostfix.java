package uvg;

public class CalculadoraPostfix implements Interfaz {
    private StackVector<Integer> stack; // creamos el objeto de tipo Stack

    // Constructor
    public CalculadoraPostfix() {
        stack = new StackVector<>();  
    }

    @Override
    public int evaluar(String operacion) {
        String[] tokens = operacion.split(" "); // Dividimos la cadena en espacios

        for (String token : tokens) {
            // Verificamos si el token es un número directamente dentro de evaluar
            boolean esNumero = true;
            try {
                Integer.parseInt(token);
            } catch (NumberFormatException e) {
                esNumero = false;
            }

            if (esNumero) {
                stack.push(Integer.parseInt(token)); // Metemos el número en la pila
            } else {
                // Extraemos el operador y operamos con los últimos dos valores en la pila
                if (stack.size() < 2) {
                    throw new IllegalStateException("Expresión inválida: faltan operandos.");
                }
                int operandoB = stack.pop();
                int operandoA = stack.pop();
                int resultado = operar(operandoA, operandoB, token);
                stack.push(resultado);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalStateException("Expresión inválida: demasiados operandos.");
        }

        return stack.pop(); // El resultado final queda en la cima de la pila
    }

    @Override
    public int operar(int operandoA, int operandoB, String operador) {
        switch (operador) {
            case "+":
                return operandoA + operandoB;
            case "-":
                return operandoA - operandoB;
            case "*":
                return operandoA * operandoB;
            case "/":
                if (operandoB == 0) {
                    throw new ArithmeticException("Error: División por cero.");
                }
                return operandoA / operandoB;
            case "%":
                return operandoA % operandoB;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }
}
