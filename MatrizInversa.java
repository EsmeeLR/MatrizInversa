import java.io.*;
import java.util.Scanner;

public class MatrizInversa {

    // Método para calcular la inversa de una matriz cuadrada
    public static double[][] inversa(double[][] matriz) {
        int n = matriz.length;
        double[][] identidad = new double[n][n];
        double[][] copia = new double[n][n];

        // Inicializar identidad y copia
        for (int i = 0; i < n; i++) {
            identidad[i][i] = 1;
            for (int j = 0; j < n; j++) {
                copia[i][j] = matriz[i][j];
            }
        }

        // Método de Gauss-Jordan
        for (int i = 0; i < n; i++) {
            // Pivote
            double pivote = copia[i][i];
            if (pivote == 0) {
                throw new ArithmeticException("La matriz no es invertible.");
            }

            for (int j = 0; j < n; j++) {
                copia[i][j] /= pivote;
                identidad[i][j] /= pivote;
            }

            // Eliminar otras filas
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = copia[k][i];
                    for (int j = 0; j < n; j++) {
                        copia[k][j] -= factor * copia[i][j];
                        identidad[k][j] -= factor * identidad[i][j];
                    }
                }
            }
        }

        return identidad;
    }

    // Método para imprimir la matriz como enteros
    public static void imprimirMatriz(double[][] matriz) {
        for (double[] fila : matriz) {
            for (double valor : fila) {
                System.out.print((int) valor + " ");
            }
            System.out.println();
        }
    }

    // Guardar matriz en archivo como enteros
    public static void guardarEnArchivo(double[][] matriz, String nombreArchivo) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
        for (double[] fila : matriz) {
            for (double valor : fila) {
                bw.write((int) valor + " ");
            }
            bw.newLine();
        }
        bw.close();
    }

    // Programa principal para probar
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el tamaño de la matriz cuadrada (n x n):");
        int n = sc.nextInt();
        double[][] matriz = new double[n][n];

        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = sc.nextDouble();
            }
        }

        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        try {
            double[][] inversa = inversa(matriz);

            System.out.println("Matriz inversa:");
            imprimirMatriz(inversa);

            // Guardar en archivo
            guardarEnArchivo(inversa, "salida.txt");
            System.out.println("La matriz inversa se guardó en salida.txt");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close(); // cerrar Scanner
    }
}