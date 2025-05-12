import java.util.Scanner;

public class MenuCacHinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1.Print the rectangle");
            System.out.println("2.Print the square triangle.");
            System.out.println("3.Print isosceles triangle.");
            System.out.println("4.Exit");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Hay nhap chieu dai.");
                    int length1 = scanner.nextInt();
                    System.out.print("Hay nhap chieu rong.");
                    int width = scanner.nextInt();
                    for(int i = 1; i <= width; i++){
                        for(int j = 1; j <= length1; j++){
                            System.out.print("*" + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("Hay nhap chieu dai.");
                    int length2 = scanner.nextInt();
                    for(int i = 1; i <= length2; i++){
                        for(int j = 1; j <= i; j++){
                            System.out.print("*" + " ");
                        }
                        System.out.println();
                    }
                    for(int i = 1; i <= length2; i++){
                        for(int j = length2; j >= i; j--){
                            System.out.print("*"+" ");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.print("Hay nhap chieu dai.");
                    int length3 = scanner.nextInt();
                    for (int i = 1; i <= length3; i++) {
                        for (int space = 1; space <= length3 - i; space++) {
                            System.out.print(" ");
                        }
                        for (int star = 1; star <= 2 * i - 1; star++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.print("Thoat.......");
                    System.exit(4);
                default:
                    System.out.println(" ");
            }
        }while(true);
    }
}