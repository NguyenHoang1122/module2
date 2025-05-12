import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        int numbers;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong so nguyen to can in ra :");
        numbers = scanner.nextInt();
        int count = 0;
        int number1 = 2;
        while(count < numbers){
            if(isPrimeNumber(number1)){
                System.out.println(number1+" ");
                count++;
            }
            number1++;
        }
        scanner.close();
    }
    public static boolean isPrimeNumber(int number){
        if(number < 2) return false;
        for(int i=2; i<= Math.sqrt(number); i++){
            if(number % i == 0) return false;
        }
        return true;
    }
}
