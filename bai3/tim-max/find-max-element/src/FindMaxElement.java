import java.util.Scanner;

public class FindMaxElement {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size : ");
            size = scanner.nextInt();
            if (size > 20) System.out.println("Size should not exceed 20.");
        }while(size > 20);
            array = new int[size];
            int i = 0;
            while(i < size){
                System.out.print("Enter element " + (i+1) + " : ");
                array[i] = scanner.nextInt();
                i++;
            }
            System.out.println("Property list : ");
        for (int k : array) {
            System.out.print(k + "\t");
        }
            int max = array[0];
            int index = 1;
            for(int j = 1; j < array.length; j++){
                if(array[j] > max){
                    max = array[j];
                    index = j + 1;
                }
            }
            System.out.println("The largest property value in the list is " + max + " ,at position " + index);
    }
}
