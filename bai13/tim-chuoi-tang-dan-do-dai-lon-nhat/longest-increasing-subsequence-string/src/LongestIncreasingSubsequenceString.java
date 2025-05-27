import java.util.Arrays;

public class LongestIncreasingSubsequenceString {
    public static String lengthOfLIS(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int[] prev = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxLen = 1;
        int andIndex = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) > s.charAt(j) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                andIndex = i;
            }
        }

        StringBuilder lis = new StringBuilder();
        for (int i = andIndex; i >= 0; i = prev[i]) {
            lis.append(s.charAt(i));
            if (prev[i] == -1) break;
        }
        return lis.reverse().toString();
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Chuoi dai nhat la : " + lengthOfLIS(input));
    }
}
