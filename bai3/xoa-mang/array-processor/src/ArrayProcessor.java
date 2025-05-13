import java.util.Arrays;
import java.util.Scanner;

public class ArrayProcessor {
    public static double countOccurrences(int[] arr, int index){
        int count = 0;
        for (int j : arr) {
            if (j == index) {
                count++;
            }
        }
        return count;
    }
    public static int[] removeElement(int[] arr, int indexToRemove) {
        double count = countOccurrences(arr, indexToRemove);
        int newCount = (int) count;
        StringBuilder result = new StringBuilder(); // su dung khi can ghi vi tri
        int[] newArr = new int[(int) (arr.length - count)];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != indexToRemove) {
                newArr[j] = arr[i];
                j++;
            } else result.append(i + 1).append(" ");
        }
        if (newCount == 0) {
            System.out.println("Không có phần tử " + indexToRemove + " nào trong mảng đã nhập.");
            System.exit(0);
        } else {
            System.out.println("Có " + newCount + " phần tử " + indexToRemove + " nằm ở vị trí " + result);
            System.out.println("Mảng mới sau khi xóa phần tử " + indexToRemove + " : ");
        }
        return newArr;
    }
    public static int[] numberList(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập độ dài mảng muốn nhập : ");
        int arrlength =  scanner.nextInt();
        int[] arr = new int[arrlength];
        for(int i = 0; i < arrlength; i++){
            System.out.print("Nhập phần tử thứ " + (i+1) + " : ");
            int number = scanner.nextInt();
            arr[i] = number;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arr = numberList();
        System.out.println("Nhập giá trị muốn xóa trong mảng : ");
        int deleteNumber = scanner.nextInt();
        int[] newArr = removeElement(arr, deleteNumber);
        System.out.print(Arrays.toString(newArr));
    }
}
