import java.util.Scanner;

public class CalculationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hãy nhập x : ");
        int x = scanner.nextInt();
        System.out.print("Hãy nhập y : ");
        int y = scanner.nextInt();
        CalculationExample example = new CalculationExample();
        example.calculation(x,y);
    }

    private void calculation(int x,int y) {
        try{
            int a = x + y;
            int b = x - y;
            int c = x * y;
            double d = (double)x / y;
            System.out.println("Tổng " + x + " + " + y + " = " + a);
            System.out.println("Hiệu " + x + " - " +  y + " = " + b);
            System.out.println("Tích " + x + " * " + y + " = " + c);
            System.out.println("Thương " + x + " / " + y + " = " + d);
        }catch(Exception e){
            System.out.println("Xảy ra ngoại lệ : " + e.getMessage());
        }
    }
}
