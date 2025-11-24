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

    }
}