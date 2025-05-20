public class TriangleClassifier {
    public static String classify(int a, int b, int c) {
        if (!isTriangle(a, b, c)) {
            return "Không phải là tam giác";
        }
        if (a == b && b == c) {
            return "Tam giác đều";
        }
        if (a == b || b == c || a == c) {
            return "Tam giác cân";
        }
        return "Tam giác thường";
    }
    private static boolean isTriangle(int a, int b, int c) {
        return (a + b > c && a + c > b && b + c > a) && (a > 0 && b > 0 && c > 0);
    }
}
