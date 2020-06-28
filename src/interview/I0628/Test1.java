package interview.I0628;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 请完成一个简单的算法编程。
 * 输入一个字符串s，我们可以删除字符串s中的任意字符，让剩下
 * 的字符串形成一个对称字符串，且该字符串为最长对称字符串。如：
 * 输入google，则找到最长对称字符串为goog；如输入abcda则能找
 * 到3个最长对称字符串为aba/aca/ada。 若最长对称字符串存在多个，
 * 则输出多个相同长度的最长对称字符串，且字符串中不包含特殊字符。
 *
 * @author wy
 * @data 2020-06-28 20:58
 */
public class Test1 {
    private static List<String> result = new LinkedList<>();

    public static void main(String[] args) {
        String str = "google";

        Test1 test1 = new Test1();
        StringBuilder sb = new StringBuilder(str);
        test1.getLCS(str, sb.reverse().toString());
        result.forEach( x -> System.out.println(x + ""));
    }

    public void getLCS(String str, String reStr) {
        int[][] a = new int[str.length() + 1][reStr.length() + 1];
        char[][] b = new char[str.length() + 1][reStr.length() + 1];

        for (int i = 0; i <= str.length(); i++) {
            a[i][0] = 0;
        }
        for (int j = 0; j <= reStr.length(); j++) {
            a[0][j] = 0;
        }

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= reStr.length(); j++) {
                if (str.charAt(i - 1) == reStr.charAt(j - 1)) {
                    a[i][j] = a[i - 1][j - 1] + 1;
                    b[i][j] = 'x';
                } else if (a[i - 1][j] >= a[i][j - 1]) {
                    a[i][j] = a[i - 1][j];
                    b[i][j] = 'h';
                } else {
                    a[i][j] = a[i][j - 1];
                    b[i][j] = 'w';
                }
            }
        }
        printLcs(b, str, str.length(), reStr.length());
        String res = "";
        while(!stack.empty()) {
            res += stack.pop().toString();
        }
        result.add(res);
    }

    private Stack<Character> stack = new Stack<Character>();

    private void printLcs(char b[][], String str, int i, int j) {
        if (i == 0 || j == 0) {
        } else if (b[i][j] == 'x') {
            stack.push(str.charAt(i - 1));
            printLcs(b, str, i - 1, j - 1);
        } else if (b[i][j] == 'h') {
            printLcs(b, str, i - 1, j);
        } else {
            printLcs(b, str, i, j - 1);
        }
    }

    public int compare(int left, int right, int max, String str) {
        int len = str.length();
        int clen = 0;

        int l = left, r = right;
        while (l <= r) {
            if (str.charAt(l) == str.charAt(r)) {
                clen++;
                l--;
                r--;
            } else {
                r--;
            }
        }
        return clen > max ? clen : max;
    }
}
