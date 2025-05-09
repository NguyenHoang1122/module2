import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        double money;
        int month;
        double interestRate;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter investment amount: ");
        money = scanner.nextDouble();
        System.out.print("Enter number of months: ");
        month = scanner.nextInt();
        System.out.print("Enter annual interest rate in percentage: ");
        interestRate = scanner.nextDouble();
        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += money *(interestRate/100)/12*month;
        }
        System.out.printf("Total interest: %.2f%n", totalInterest);
    }
}
