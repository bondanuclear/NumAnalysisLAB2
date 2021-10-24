package numAn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.function.DoubleBinaryOperator;

public class Main {

    public static void main(String[] args) {
	// write your code here
       // Gauss.GaussMethod();
        //double[] x = new double[10];
     // Tridiagonal.solve(new double[] {0,2,3}, new double[] {1,2,2}, new double[] {2,3,0},
        //        new double[] {8,21,17});
        Seidel slae = new Seidel();
        double[][] A = { { 6, 0, 2, 3,35 }, { 0, 4, 2, 1,25 }, { 2, 2, 5, 0,30 }, {3,1,0,5,34} };
        double[] x = slae.findSolution(A);
        for (double[] d : A) {
            System.out.println(Arrays.toString(d));
        }
        System.out.println(Arrays.toString(x));
    }
}
