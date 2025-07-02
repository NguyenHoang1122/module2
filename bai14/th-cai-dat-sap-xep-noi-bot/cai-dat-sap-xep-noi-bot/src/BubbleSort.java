import java.util.Scanner;

public class BubbleSort {
    //    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    public static void myList() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size : ");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values : ");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list : ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println("\nBegin sort processing...");
        bubbleSort(list);
    }

    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;
        for (int i = 1; i < list.length && needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < list.length - i; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    needNextPass = true;
                }
            }
        }
        System.out.print("List after sort : ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
    }
}
