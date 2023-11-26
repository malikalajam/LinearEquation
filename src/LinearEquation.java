import java.util.Scanner;

public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public double yIntercept() {
        return roundedToHundredth(y1 - slope() * x1);
    }

    public double slope() {
        if (x2 - x1 == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
    }

    public String slopeAsFraction() {
        double m = slope();
        if (m == Double.POSITIVE_INFINITY) {
            return "Undefined";
        } else {
            return Double.toString(m);
        }
    }

    public String equation() {
        double m = slope();
        double b = yIntercept();

        if (Double.isInfinite(m)) {
            return "x = " + x1;
        } else if (m == 0) {
            return "y = " + b;
        } else {
            int numerator = y2 - y1;
            int denominator = x2 - x1;
            String slopeFraction = "(" + Math.abs(numerator) + "/" + Math.abs(denominator) + ")";
            String slopeTerm = (m < 0) ? "-" + slopeFraction : slopeFraction;
            return "y = " + slopeTerm + "x" + (b >= 0 ? " + " : " - ") + Math.abs(b);
        }
    }

    public String coordinateForX(double xValue) {
        if (slope() == 0) {
            return "(" + xValue + ", " + y1 + ")";
        } else {
            double y = roundedToHundredth(slope() * xValue + yIntercept());
            return "(" + xValue + ", " + y + ")";
        }
    }

    public double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }

    public String lineInfo() {
        String info = "The original points: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n";

        String equationInfo = "The equation of the line: " + equation() + "\n";
        info = info + equationInfo;

        String slopeInfo = "The slope of the line: " + slope() + "\n";
        info = info + slopeInfo;

        String yInterceptInfo = "The y-intercept of the line: " + yIntercept() + "\n";
        info = info + yInterceptInfo;

        String distanceInfo = "The distance between the two points: " + distance();
        info = info + distanceInfo;

        return info;
    }
}



