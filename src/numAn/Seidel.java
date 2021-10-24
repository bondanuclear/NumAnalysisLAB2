package numAn;

public class Seidel {
    double EPS = 10e-6;

    public double[] findSolution(double[][] matrix) {
        return findSolution(matrix, EPS);
    }

    public double[] findSolution(double[][] matrix, double eps) {
        int size = matrix.length;
        double[] previousVariableValues = new double[size];
        for (int i = 0; i < size; i++) {
            previousVariableValues[i] = 0.0;
        }

        while (true) {

            double[] currentVariableValues = new double[size];


            for (int i = 0; i < size; i++) {

                currentVariableValues[i] = matrix[i][size];


                for (int j = 0; j < size; j++) {

                    if (j < i) {
                        currentVariableValues[i] -= matrix[i][j] * currentVariableValues[j];
                    }


                    if (j > i) {
                        currentVariableValues[i] -= matrix[i][j] * previousVariableValues[j];
                    }
                }


                currentVariableValues[i] /= matrix[i][i];
            }


            double error = 0.0;

            for (int i = 0; i < size; i++) {
                error += Math.abs(currentVariableValues[i] - previousVariableValues[i]);
            }


            if (error < EPS) {
                break;
            }



            previousVariableValues = currentVariableValues;
        }

        return previousVariableValues;
    }
}
