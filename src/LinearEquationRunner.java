import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first point (x1, y1):");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        System.out.println("Enter the second point (x2, y2):");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        LinearEquation linearEquation = new LinearEquation(x1, y1, x2, y2);

        double distance = linearEquation.distance();
        String slopeAsFraction = linearEquation.slopeAsFraction();
        double yIntercept = linearEquation.yIntercept();
        String equation = linearEquation.equation();

        System.out.println("distance between the points: " + distance);
        System.out.println("slope of the line: " + slopeAsFraction);
        System.out.println("y intercept: " + yIntercept);
        System.out.println("linear equation: " + equation);

        System.out.println("Enter an x value to solve for y:");
        double x = scanner.nextDouble();
        String coordinateForX = linearEquation.coordinateForX(x);
        System.out.println("The point on the line with x = " + x + " is " + coordinateForX);
    }
}