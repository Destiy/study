public class ShortTest {

    public static void main(String[] args) {
//        short s1 = 1;

//        System.out.println(maxVowels("abciiidef", 3));
        System.out.println(maxVowels("weallloveyou", 7));
//        s1 = s1 + 1;
//        s1 += 1;

    }

    public static int maxVowels(String s, int k) {
        int[] dp = new int[s.length() + 1];
        int[] tmp = new int[s.length() + 1];
        String str = "aeiou";
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && i >= k) {
                dp[i] = dp[i-1] - tmp[i-k];
            } else if (i > 0) {
                dp[i] = dp[i - 1];
            }
            if (str.contains(s.charAt(i) + "")) {
                tmp[i] = 1;
                dp[i] += 1;
            }
            max = Math.max(dp[i], max);
        }
        return max;

    }
}
