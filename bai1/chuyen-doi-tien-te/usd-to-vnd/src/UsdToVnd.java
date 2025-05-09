import java.util.Scanner;

public class UsdToVnd {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so tien USD :");
        usd = scanner.nextDouble();
        double quydoi = usd*vnd;
        System.out.print("Gia tri VND : " + quydoi + " VND.");
    }
}
