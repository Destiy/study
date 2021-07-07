import java.util.*;

/**
 * @author wy
 * @date 2020/12/18
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();

//        test.calculate("3+2*2");
//        System.out.println(Integer.parseInt("+" + "3"));
//        System.out.println(test.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));


//        System.out.println(test.singleNumber(new int[]{2,2,3,2}));
//        test.testXOR();
//        test.decode(new int[]{6,5,4,6});
//        new ListNode()
        test.merge(new int[]{4,5,6,0,0,0,0}, 3, new int[]{1,2,3,9},4);
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        s += " ";
        String symbol = "";
        for (int i = 0; i < s.length(); i++) {
            char ic = s.charAt(i);
            if (ic == ' ') {
                continue;
            }
            if (ic >= 48 && ic <= 57) {
                for (int j = i; j < s.length(); j++) {
                    char jc = s.charAt(j);
                    if (jc < 48 || jc > 57) {
                        String substring = s.substring(i, j);
                        if (symbol.equals("*")) {
                            Integer t = stack.pop();
                            stack.push(t * Integer.parseInt(substring));
                        } else if (symbol.equals("/")) {
                            Integer t = stack.pop();
                            stack.push(t / Integer.parseInt(substring));
                        } else {
                            stack.push(Integer.parseInt(symbol + substring));
                        }
                        i = j - 1;
                        break;
                    }
                }
            } else {
                symbol = ic + "";
            }
        }
        while (stack.size() != 1) {
            Integer n1 = stack.pop();
            Integer n2 = stack.pop();
            stack.push(n1 + n2);
        }
        return stack.pop();
    }

    public boolean isValidSerialization(String preorder) {
        int length = preorder.length();
        int i = 0;
        int cnt = 1;
        while (i < length) {
            if (cnt == 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                cnt--;
                i++;
            } else {
                while (i < length && preorder.charAt(i) != ',') {
                    i++;
                }
                cnt++;
            }
        }
        return cnt == 0;
    }

    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            if (c % i != 0) {
                continue;
            }
            int exp = 0;
            while (c % i == 0) {
                exp++;
                c /= i;
            }

            if (i % 4 == 3 && exp % 2 != 0) {
                return false;
            }
        }
        return c % 4 != 3;
    }

    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }


    public int singleNumber(int[] nums) {

        int one = 0, two = 0, three;
        for (int num : nums) {
            // two的相应的位等于1，表示该位出现2次
            two |= (one & num);
            // one的相应的位等于1，表示该位出现1次
            one ^= num;
            // three的相应的位等于1，表示该位出现3次
            three = (one & two);
            // 如果相应的位出现3次，则该位重置为0
            two &= ~three;
            one &= ~three;
        }
        return one;
    }

    public void testXOR() {
        int res = 1;
        for (int i = 3; i < 99; i += 2) {
            res = res ^ i ^ (i - 1);
            System.out.println("i = " + i + ", " + res + ", mod = " + (i + 1) / 2);
        }
    }

    public int[] decode(int[] encoded) {
        Arrays.sort(encoded);
        int n = encoded.length + 1;
        int[] res = new int[n];
        int tmp = ((n + 1) / 2) % 2;
        for (int i = 1; i < n - 1; i += 2) {
            tmp ^= encoded[i];
        }
        res[0] = tmp;
        for (int i = 1; i < n; i++) {
            res[i] = encoded[i - 1] ^ res[i - 1];
        }
        return res;
    }

    public void exchangeNums(int a, int b) {
        b = a ^ b;
        a = a ^ b;
        b = a ^ b;
        System.out.println(a + " " + b);
    }



     class ListNode {
       int val;
       ListNode next = null;

         public ListNode(int val) {
             this.val = val;
         }
     }

    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode cur = result.next;

        while (k > 1) {
            k--;
            ListNode next = cur.next;
            ListNode next2 = next.next;
            cur.next = next2;
            next.next = cur;
            result.next = next;
            cur = cur.next;

        }
        return result.next;
    }

    public int maxLength (int[] arr) {
        // write code here
        int start = 0, res = 0;
        int[] tmp = new int[100005];
        for (int i = 0; i < arr.length; i++) {
            int t = arr[i];
            if (tmp[t] > start) {
                start = tmp[t];
            }
            res = Math.max(res, i - start + 1);
            tmp[t] = i + 1;
        }
        return res;
    }

    public void merge(int A[], int m, int B[], int n) {
        int ai = m - 1, bi = n - 1, li = m + n - 1;
        while (ai >= 0 && bi >= 0) {
            if (A[ai] > B[bi]) {
                A[li--] = A[ai--];
            } else {
                A[li--] = B[bi--];
            }
        }
        while(bi >= 0) {
            A[li--] = B[bi--];
        }
        Stack<String> st = new Stack<>();
        char c = '2';
        String pop = st.pop();
        st.push(c + "");

        List<Integer> list = new ArrayList<>();
    }

}
