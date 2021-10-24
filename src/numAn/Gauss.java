package numAn;

import java.util.Arrays;
import java.util.Scanner;

public class Gauss {
    public static void GaussMethod() {
        /* Data input */

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        double[][] A = new double[100][100];
        double[] b = new double[100];
        for (int i = 0; i < n; i++) {
            A[i] = new double[100];
            for (int j = 0; j < m; j++) {
                A[i][j] = s.nextDouble();
               // System.out.println(A[i][j]);
            }
            b[i] = s.nextDouble();
           // System.out.println(b[i]);
        }

        /* Gaussian Method */

        int N  = n;
        for (int p = 0; p < N; p++) {

            int max = p;
            for (int i = p + 1; i < N; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p];
            A[p] = A[max];
            A[max] = temp;
            //System.out.println(Arrays.toString(A[max]) + " A max");
            double t = b[p];
            b[p] = b[max];
            b[max] = t;
            System.out.println(b[max] + "b max");
            if (Math.abs(A[p][p]) <= 1e-10) {
                System.out.println("Не існує відповіді");
                return;
            }

            for (int i = p + 1; i < N; i++) {
                double alpha = A[i][p] / A[p][p];
                System.out.println("Alpha[k][j] coef " + alpha + " [i][p]" + i + " " + p );
                b[i] -= alpha * b[p];
                System.out.println("Alpha[i][j]  = " + b[i] + " [i][p]" + i + " " + p);

                for (int j = p; j < N; j++) {
                    A[i][j] -= alpha * A[p][j];
                    System.out.println("ALPHA[i][j] = " + A[i][j]);
                }
            }
        }

        // Обратный проход

        double[] x = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }

        /* Output */

        if (n < m) {
            System.out.print("Нескінченна кількість розвязків");
        } else {
            System.out.println("Розвязок існує і він єдиний");
            for (int i = 0; i < N; i++) {
                System.out.print(x[i] + " ");
            }
        }
    }
}
