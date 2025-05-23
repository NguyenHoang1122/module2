import java.util.Stack;

public class ReversesArrayInteger {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};

        Stack<Integer> stack = new Stack<>();

        for(int num: arr){
            stack.push(num);
        }
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = stack.pop();
        }

        for(int num: arr){
            System.out.print(num + " ");
        }
    }
}
