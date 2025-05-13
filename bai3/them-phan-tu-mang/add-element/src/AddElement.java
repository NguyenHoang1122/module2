import java.util.Arrays;
import java.util.Scanner;

public class AddElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.print("Nhập số muốn thêm vào mảng : ");
        int number = scanner.nextInt();
        System.out.print("Nhập vị trí muốn thêm số vào mảng : ");
        int index = scanner.nextInt();
        if(index < 1 || index > arr.length){
            System.out.println("Không thể chèn được vào mảng.");
        }else{
            for(int i = arr.length-1; i > index; i--){
                arr[i] = arr[i-1];
            }
            arr[index - 1] = number;
        }
        System.out.println("Mảng mới sau khi thêm phần tử " + number + " vào vị trí " + index + " là : ");
        System.out.print(Arrays.toString(arr));
    }
}
