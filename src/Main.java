import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Matrix matrix = new Matrix(n, m);

        int a = sc.nextInt();
        int b = sc.nextInt();
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

