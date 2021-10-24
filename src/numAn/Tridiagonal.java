package numAn;

public class Tridiagonal {
    public static void solve(double[] a, double[] b, double[] c, double[] d) {
        int n = d.length;
        double[] x = new double[n+1];
        c[0] /= b[0];
        System.out.println(c[0]);
        d[0] /= b[0];
        System.out.println(d[0]);
        for (int i = 1; i < n; i++) {
            double id = (b[i] - c[i - 1] * a[i]);
            System.out.println(id + " ");
            c[i] /= id;
            System.out.println(c[i] + "c[i]");
            d[i] = (d[i] - d[i - 1] * a[i]) / id;
            System.out.println(d[i] + "d[i] ");
        }

        /* Now back substitute. */
        x[n - 1] = d[n - 1];
        for (int i = n - 1; i >= 0; i--)
            System.out.println(x[i] = d[i] - c[i] * x[i + 1]);
    }



}
