import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size : ");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter list values : ");
        for (int i = 0; i < size; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list : ");
        printArray(list);
        System.out.println("\nBegin sort processing...");
        insertionSort(list);
    }

    public static void insertionSort(int[] list) {
        int pos, x;
        for (int i = 1; i < list.length; i++) {
            x = list[i];
            pos = i;
            while (pos > 0 && x < list[pos - 1]) {
                list[pos] = list[pos - 1];
                pos--;
            }
            list[pos] = x;
            System.out.println("List after the " + i + " sort :");
            printArray(list);
        }
    }
    public static void printArray(int[] list) {
        for (int num : list) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }
}
