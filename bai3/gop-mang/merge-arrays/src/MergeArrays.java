import java.util.Arrays;
import java.util.Scanner;

public class MergeArrays {
    public static int[] addArrayss1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử mảng thứ nhất : ");
        int number1 = scanner.nextInt();
        int[] arr = new int[number1];
        for(int i = 0; i < number1; i++){
            System.out.print("Nhập giá trị phần tử thứ " + (i + 1) + ": ");
            int value1 = scanner.nextInt();
            arr[i]=value1;
        }
        return arr;
    }
    public static int[] addArrayss2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử mảng thứ hai : ");
        int number2 = scanner.nextInt();
        int[] arr1 = new int[number2];
        for(int i = 0; i < number2; i++){
            System.out.print("Nhập giá trị phần tử thứ " + (i + 1) + ": ");
            int value2 = scanner.nextInt();
            arr1[i]=value2;
        }
        return arr1;
    }
    public static void main(String[] args) {
        int[] arr1 = addArrayss1();
        int[] arr2 = addArrayss2();
        int[] arr3 = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
        System.out.println(Arrays.toString(arr3));
    }
}
