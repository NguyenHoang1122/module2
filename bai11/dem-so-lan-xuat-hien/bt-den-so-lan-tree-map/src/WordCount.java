import java.util.Scanner;
import java.util.TreeMap;

public class WordCount {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        String[] words = input.split("\\s+");
        TreeMap<String, Integer> map=new TreeMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        System.out.println("Word count:");
        for (String word : map.keySet()) {
            System.out.println(word + ": " + map.get(word));
        }
        scanner.close();
    }
}
