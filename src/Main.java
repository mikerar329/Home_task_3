import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input number of columns and rows: ");
        int n = sc.nextInt();
        while (n < 1) {
            System.out.println("Input positive N");
            n = sc.nextInt();
        }
        int m = sc.nextInt();
        while (m < 1) {
            System.out.println("Input positive m");
            m = sc.nextInt();
        }


        Matrix matrix = new Matrix(n, m);
        System.out.println("Input generating numbers range(from a to b) ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        matrix.randomFill(a, b);
        matrix.output();
        System.out.println();
        matrix.extremum();
        matrix.getGeomAndArithmMean();
        matrix.transporate();
        System.out.println();
        matrix.findLocalMaxMin();
    }

}

