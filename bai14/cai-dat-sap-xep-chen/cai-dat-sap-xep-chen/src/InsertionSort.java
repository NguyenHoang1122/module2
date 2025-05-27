public class InsertionSort {
    static int[] list = {12, 11, 5, 7, 8};
    public static void insertionSort(int[] list) {
        int pos, x;
        printArray(list);
        for (int i = 1; i < list.length; i++) {
            x = list[i];
            pos = i;
            while (pos > 0 && x < list[pos - 1]) {
                list[pos] = list[pos - 1];
                pos--;
            }
            list[pos] = x;
        }
        printArray(list);
    }

    public static void printArray(int[] list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insertionSort(list);
    }
}
