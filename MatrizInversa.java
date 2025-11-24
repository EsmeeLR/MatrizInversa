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

    // Método para imprimir la matriz
    public static void imprimirMatriz(double[][] matriz) {
        for (double[] fila : matriz) {
            for (double valor : fila) {
                System.out.printf("%.2f ", valor);
            }
            System.out.println();
        }
    }

    // Guardar matriz en archivo
    public static void guardarEnArchivo(double[][] matriz, String nombreArchivo) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
        for (double[] fila : matriz) {
            for (double valor : fila) {
                bw.write(String.format("%.2f ", valor));
            }
            bw.newLine();
        }
        bw.close();
    }
}