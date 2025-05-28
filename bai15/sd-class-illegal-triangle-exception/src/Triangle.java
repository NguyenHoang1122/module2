import java.util.Scanner;

public class Triangle {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) throws IllegalArgumentException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Các cạnh không hợp lệ.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhạp cạnh thứ nhất : ");
            double a = sc.nextDouble();
            System.out.print("Nhạp cạnh thứ hai : ");
            double b = sc.nextDouble();
            System.out.print("Nhạp cạnh thứ ba : ");
            double c = sc.nextDouble();
            Triangle t = new Triangle(a, b, c);
            System.out.println(t);
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi : " + e.getMessage());
        }
    }

    public String toString() {
        return "Ba cạnh của tam giác : " + a + " " + b + " " + c;
    }
}
