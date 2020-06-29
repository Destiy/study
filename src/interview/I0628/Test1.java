package interview.I0628;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

/**
 * @author wy
 */
public class Test1 {
    /**
     * 结果集
     */
    private static Set<String> result;

    public static void main(String[] args) {
        // 输出最长对称字符串：goog
        String input1 = "google";

        // 输出3个最长对称字符串：aba/aca/ada
        String input2 = "abcda";

        // 输出2个最长对称字符串：pop/upu，不会输出特殊字符的对称字符串p-p
        String input3 = "pop-upu";

        String s = StringFilter(input3);
        result = new HashSet<>(s.length());
        Test1 test1 = new Test1();

        StringBuilder sb = new StringBuilder(s);
        test1.getLCS(s, sb.reverse().toString());
        result.forEach(x -> System.out.print(x + " "));
    }

    /**
     * lcs 遍历
     *
     * @param str   字符串
     * @param reStr 反转字符串
     */
    public void getLCS(String str, String reStr) {
        int[][] dp = new int[str.length() + 1][reStr.length() + 1];
        char[][] map = new char[str.length() + 1][reStr.length() + 1];

        for (int i = 0; i <= str.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= reStr.length(); j++) {
            dp[0][j] = 0;
        }

        // x-斜对角 h-上&左 l-左 u-上
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= reStr.length(); j++) {
                // 特判特殊字符处理
                if (str.charAt(i - 1) == '-') {
                    continue;
                }
                if (str.charAt(i - 1) == reStr.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    map[i][j] = 'x';
                } else if (dp[i - 1][j] == dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    map[i][j] = 'h';
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    map[i][j] = 'l';
                } else {
                    dp[i][j] = dp[i][j - 1];
                    map[i][j] = 'u';
                }
            }
        }
        // 处理特殊符号分割字符
        Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                integers.add(i);
            }
        }
        integers.add(str.length());
        for (Integer integer : integers) {
            findLCS(map, str, integer, reStr.length(), "");
        }
    }

    /**
     * 过滤特殊字符
     *
     * @param str 带过滤字符串
     * @return 过滤后的带 ‘-’ 占位，字符串
     */
    public static String StringFilter(String str) {
        // 清除掉所有特殊字符, 使用 '-' 占位
        String s = str.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，,。？“”]+", "-");
        return s.replaceAll("[-]+", "-");

        // TODO 如果特殊符号可以忽略，注释上面两行，使用下面正则过滤
//        return str.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，,。？“”]+", "");
    }

    /**
     * 遍历所有路径
     *
     * @param map 图
     * @param str 字符串
     * @param i   x轴
     * @param j   y轴
     * @param res 路径
     */
    private void findLCS(char[][] map, String str, int i, int j, String res) {
        if (i == 0 || j == 0) {
            result.add(res);
        } else if (map[i][j] == 'x') {
            findLCS(map, str, i - 1, j - 1, res + str.charAt(i - 1));
        } else if (map[i][j] == 'h') {
            findLCS(map, str, i - 1, j, res);
            findLCS(map, str, i, j - 1, res);
        } else if (map[i][j] == 'l') {
            findLCS(map, str, i - 1, j, res);
        } else {
            findLCS(map, str, i, j - 1, res);
        }
    }
}
