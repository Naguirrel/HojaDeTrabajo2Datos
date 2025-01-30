package uvg;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StackVector<Integer> stack = new StackVector<>();//LINEA QUE SE PUEDE CAMBIAR

        //Primero leer el archivo txt
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/datos.txt"))) {
            String linea; // Crear una variable con el archivo txt
            //Verificar que el archivo txt no este vacio
            while ((linea = br.readLine()) != null) {
                String[] tokens = linea.split(" ");//
                
                for (String token : tokens) {
                    if (esNumero(token)) {
                        stack.push(Integer.parseInt(token));
                    } else {
                        // Si es un operador, sacamos dos números de la pila y realizamos la operación
                        int b = stack.pop();
                        int a = stack.pop();
                        int resultado = operar(a, b, token);
                        stack.push(resultado);
                    }
                }
                // Al final de la línea, la pila debe contener el resultado final
                System.out.println("Resultado: " + stack.pop());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
    }
    // Método para verificar si un string es un número
    private static boolean esNumero(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Método para realizar operaciones básicas
    private static int operar(int a, int b, String operador) {
        switch (operador) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: throw new IllegalArgumentException("Operador desconocido: " + operador);
        }
    }
}

   

