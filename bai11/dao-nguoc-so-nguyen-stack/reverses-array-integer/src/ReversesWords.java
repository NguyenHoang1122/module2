import java.util.Stack;

public class ReversesWords {
    public static void main(String[] args) {
        String inputWords = "củ 5 Jack";
        Stack<String> wordsStack = new Stack<>();

        String[] words = inputWords.split(" ");
        for (String word : words) {
            wordsStack.push(word);
        }

        StringBuilder output = new StringBuilder();
        while (!wordsStack.isEmpty()) {
            String word = wordsStack.pop();
            output.append(word);
            if (!wordsStack.isEmpty()) {
                output.append(" ");
            }
        }
        System.out.println(output);
    }
}
