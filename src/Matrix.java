import java.util.Random;


public class Matrix {
    private double[][] matrix;

    Matrix(int n, int m) {
        matrix = new double[n][m];
    }

    void randomFill(int a, int b) {
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

    void transporate() {
        double transpMatrix[][] = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpMatrix[j][i] = matrix[i][j];
            }
        }
        System.out.println("Transposed matrix: ");
        output(transpMatrix);
    }

    void findLocalMaxMin() {
        int i = 0;
        int j = 0;
        boolean stopMin = true;
        boolean stopMax = true;
        for (i = 0; i < matrix.length && (stopMin || stopMax); i++) {
            for (j = 0; j < matrix[0].length && (stopMin || stopMax); j++) {
                if (localMin(i, j) && stopMin) {
                    System.out.println("LocalMin is " +  String.format("%.7g  ", (matrix[i][j])));
                    stopMin = false;
                }
                if (localMax(i, j) && stopMax) {
                    System.out.println("LocalMax is " +  String.format("%.7g  ", (matrix[i][j])));
                    stopMax = false;
                }
            }
        }
        System.out.println();
        if (stopMax) {
            System.out.println("There is no localMax");
            System.exit(0);
        }
        if (stopMin) {
            System.out.println("There is no localMin");
            System.exit(0);
        }

    }

    private boolean localMin(int i, int j) {
        double value = matrix[i][j];
        boolean isLocalMin = true;
        for (int col = j - 1; col < j + 2 && isLocalMin; col++) {
            for (int str = i - 1; str < i + 2 && isLocalMin; str++) {
                if (col >= 0 &&
                        str >= 0 &&
                        col < matrix[0].length &&
                        str < matrix.length &&
                        value > matrix[str][col]) {
                    isLocalMin = false;
                }
            }

        }
        return isLocalMin;
    }

    private boolean localMax(int i, int j) {
        double value = matrix[i][j];
        boolean isLocalMax = true;
        for (int col = j - 1; col < j + 2 && isLocalMax; col++) {
            for (int str = i - 1; str < i + 2 && isLocalMax; str++) {
                if (col >= 0 &&
                        str >= 0 &&
                        col < matrix[0].length &&
                        str < matrix.length &&
                        value < matrix[str][col]) {
                    isLocalMax = false;
                }
            }

        }
        return isLocalMax;
    }

}
