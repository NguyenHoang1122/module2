import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public Integer[] createRandom(int size, int bound) {
        Random random = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    public void printArray(Integer[] arr) {
        System.out.println("Danh sách phần tử của mảng: ");
        for (Integer num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayExample example = new ArrayExample();
        Integer[] arr = example.createRandom(100, 100);
        example.printArray(arr);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nVui lòng nhập chỉ số của một phần tử bất kỳ: ");
        int index = scanner.nextInt();
        try {
            System.out.println("Giá trị phần tử có chỉ số " + index + " là : " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Chỉ số vượt quá giới hạn của mảng.");
        }
    }
}
