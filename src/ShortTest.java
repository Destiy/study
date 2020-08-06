import java.util.Arrays;

public class ShortTest {

    public static void main(String[] args) {
//        short s1 = 1;

//        System.out.println(maxVowels("abciiidef", 3));
//        System.out.println(maxVowels("weallloveyou", 7));
//        s1 = s1 + 1;
//        s1 += 1;

        System.out.println(addStrings("999", "999"));
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

    public static String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() <= 0) {
            return num2;
        }
        if (num2 == null || num2.length() <= 0) {
            return num1;
        }
        char[] cnum1 = num1.toCharArray();
        char[] cnum2 = num2.toCharArray();
        int[] tmp = new int[5100];
        int cl1 = cnum1.length - 1;
        int cl2 = cnum2.length - 1;
        int i = 0;
        while (cl1>=0 && cl2>=0) {
            tmp[i] += cnum1[cl1--] + cnum2[cl2--] - 96;
            if (tmp[i] > 9) {
                tmp[i+1] += 1;
                tmp[i] %= 10;
            }
            i++;
        }
        while (cl1 >= 0) {
            tmp[i] += cnum1[cl1--] - 48;
            if (tmp[i] > 9) {
                tmp[i+1] += 1;
                tmp[i] %= 10;
            }
            i++;
        }
        while (cl2 >= 0) {
            tmp[i] += cnum2[cl2--] - 48;
            if (tmp[i] > 9) {
                tmp[i+1] += 1;
                tmp[i] %= 10;
            }
            i++;
        }

        StringBuilder result = new StringBuilder(tmp[i] == 0 ? "" : "" +tmp[i]);
        i--;
        while(i>=0) {
            result.append(tmp[i--]);
        }
        return result.toString();
    }
}