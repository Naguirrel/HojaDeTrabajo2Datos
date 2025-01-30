package uvg;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CalculadoraPostfix calculadora = new CalculadoraPostfix(); // Instancia de la calculadora

        // Primero leer el archivo txt
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/datos.txt"))) {
            String linea; // Crear una variable con el archivo txt

            // Verificar que el archivo txt no esté vacío
            while ((linea = br.readLine()) != null) {
                // Evaluar la expresión postfix de cada línea y mostrar el resultado
                int resultado = calculadora.evaluar(linea);
                System.out.println("Resultado: " + resultado);
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.err.println("Error en la evaluación: " + e.getMessage());
        }
    }
}


   

