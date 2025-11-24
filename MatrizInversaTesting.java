import java.io.*;
import java.util.Scanner;

public class MatrizInversaTesting {
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
        MatrizInversa.imprimirMatriz(matriz);

        try {
            double[][] inversa = MatrizInversa.inversa(matriz);

            System.out.println("Matriz inversa:");
            MatrizInversa.imprimirMatriz(inversa);

            // Guardar en archivo
            MatrizInversa.guardarEnArchivo(inversa, "salida.txt");
            System.out.println("La matriz inversa se guardó en salida.txt");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close(); // cerrar Scanner
    }
}