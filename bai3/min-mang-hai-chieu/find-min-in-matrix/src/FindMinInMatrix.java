import java.util.Scanner;

public class FindMinInMatrix {
    public static int[][] createMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số hàng : ");
        int rows = scanner.nextInt();
        System.out.print("Nhập số cột : ");
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print("Nhập giá trị vị hàng " + (i+1) + " cột " + (j+1) + " : ") ;
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = createMatrix();
        int cols = matrix[0].length;
        int min = matrix[0][0];
        for (int[] ints : matrix) {
            for (int j = 1; j < cols; j++) {
                if (ints[j] < min) {
                    min = ints[j];
                }
            }
        }
        System.out.print("Phần tử nhỏ nhất trong mảng 2 chiều là : " + min + ".");
    }
}
