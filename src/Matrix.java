import java.util.ArrayList;
import java.util.Random;

public class Matrix {
    private double[][] matrix;

    Matrix(int n, int m) {
        matrix = new double[n][m];
    }

    void rndFill(int a, int b) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = a + (b - a) * random.nextDouble();
        }
    }

    private void output(double[][] matrix) {
        for (double[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(String.format("%.7g  ", (aMatrix[j])));
            }
            System.out.print("\n");
        }
    }

    void output() {
        for (double[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(String.format("%.7g  ", (aMatrix[j])));
            }
            System.out.print("\n");
        }
    }

    private double getMaxElement() {
        double maxElement = 0;
        for (double[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (aMatrix[j] > maxElement) {
                    maxElement = aMatrix[j];
                }
            }
        }

        return maxElement;
    }

    private double getMinElement() {
        double minElement = 0;
        for (double[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (aMatrix[j] < minElement) {
                    minElement = aMatrix[j];
                }
            }
        }
        return minElement;
    }

    void extremum() {
        System.out.println("==========================\n Max value is: " + String.format("%.7g  ", (getMaxElement())));
        System.out.println("==========================\n Min value is: " + String.format("%.7g  ", (getMinElement())) +
                "\n==========================");
    }

    void getGeomAndArithmMean() {
        int sum = 0;
        double multi = 1;
        for (double[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += aMatrix[j];
                multi *= aMatrix[j];
            }
        }
        System.out.print("Average is " + String.format("%.7g%n", (double) sum / (matrix.length * matrix[0].length)));
        System.out.println("Geometric mean is " + String.format("%.7g%n", (Math.pow(Math.abs(multi),
                1.0 / (matrix.length * matrix[0].length)))));
    }

    void tranporate() {
        double transpMatrix[][] = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpMatrix[j][i] = matrix[i][j];
            }
        }
        System.out.println("Transposed matrix: ");
        output(transpMatrix);
    }

    void findLocalMaxMin(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(localMax(i, j)) {
                    System.out.print(i + " " + j);
                    continue;
                }
            }

            System.out.print("\n");
        }
    }


    public boolean localMin(int i, int j) {
        if (i == 0 && j == 0 || i == matrix.length - 1 && j == matrix[0].length - 1
                || i == 0 && j == matrix[0].length - 1 || i == matrix.length - 1 && j == 0) {
            return false;
        }
        if (i == 0 || j == 0 || i == matrix.length || j == matrix[0].length) {
            for (int ii = 1; i < matrix.length - 2; i++) {

            }
        }
        return false;
    }

    public boolean localMax(int i, int j) {
        double n = matrix.length;
        double m = matrix[0].length;

        ArrayList<Double> neighbours = new ArrayList<>(8);
        for (int x = Math.max(i-1, 0); x >= Math.min(i+1, n-1); ++x)
            for (int y = Math.max(j-1, 0); y >= Math.min(i+1, m-1); ++y)
                for (Double v : neighbours)
                    if (matrix[i][j] <= v)
                        return false;
        return true;
    }


}
