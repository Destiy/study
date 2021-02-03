import lombok.experimental.var;

import java.util.*;

/**
 * @author wy
 * @date 2020/12/18
 */
public class Test {
    public static void main(String[] args) {
        int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int b[][] = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        Test test = new Test();
//        test.rotate2(b);
//        System.out.println(b);
//        System.out.println(test.minPatches(new int[]{1,2,31,33}, 2147483647));
//        test.eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}});
        List<List<String>> questions = new ArrayList<>();
        questions.add(Arrays.asList("a", "b"));
        questions.add(Arrays.asList("b", "c"));

        List<List<String>> queries = new ArrayList<>();
//        queries.add(Arrays.asList("a", "c"));
//        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
//        test.calcEquation(questions, new double[]{2.0,3.0}, queries);
//        test.findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}});
//        test.rotate(new int[]{1,2,3,4,5,6}, 4);
//        test.maxProfit(new int[]{7,1,5,3,6,4});
        test.smallestStringWithSwaps("dcab", Arrays.asList(Arrays.asList(0,3),Arrays.asList(1,2)));
    }

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            for (int j = i; j < length - i - 1; j++) {
                int j1 = length - i - 1;
                int swap = swap(matrix, j, j1, matrix[i][j]);
                swap = swap(matrix, j1, length - j - 1, swap);
                swap = swap(matrix, length - j - 1, i, swap);
                swap(matrix, i, j, swap);
            }
        }
    }

    public int swap(int[][] matrix, int i, int j, int v) {
        int t = matrix[i][j];
        matrix[i][j] = v;
        return t;
    }

    public void rotate2(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            int j1 = length - i - 1;
            for (int j = i; j < j1; j++) {
                int temp = matrix[i][j];
                int end = length - j - 1;
                matrix[i][j] = matrix[end][i];      // 左下->左上
                matrix[end][i] = matrix[j1][end];   // 右下->左下
                matrix[j1][end] = matrix[j][j1];    // 右上->右下
                matrix[j][j1] = temp;               // 左上->右上
            }
        }
    }


    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        if (length == 0) {
            return 0;
        }
        // 并查集版本
        int[] parent = new int[length];
        for (int i = 0; i < length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            if (parent[i] == i) {
                res++;
            }
        }
        return res;
    }

    public void union(int[] parent, int i, int j) {
        parent[find(parent, i)] = find(parent, j);
    }

    public int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (length < 2 || k < 1) { return; }
        k = k % length;
        if (k < 1) {
            return;
        }
        boolean[] falgNums = new boolean[nums.length];
        int size = 0, tmp = nums[0], cnt = 0;
        while(size++ < length) {
            cnt = cnt + k < length ? cnt + k : cnt + k - length;

            int num = nums[cnt];
            nums[cnt] = tmp;
            tmp = num;
            falgNums[cnt] = true;
            int t = cnt + k < length ? cnt + k : cnt + k - length;
            while (size < length && falgNums[t]) {
                tmp = nums[++cnt];
                t = cnt + k < length ? cnt + k : cnt + k - length;
            }
        }
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            int j = i + 1, tmp = prices[i];
            while (j < prices.length && prices[j-1] < prices[j]) {
                tmp = prices[j];
                j++;
            }
            res += Math.max(0,tmp - prices[i]);
            i = j - 1;
        }
        return res;
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) { return s;}
        int length = s.length();
        Set<Integer> treeSet = new TreeSet<>();
        Set<String> tempSet = new TreeSet<>();
        StringBuilder res = new StringBuilder();
        for (List<Integer> pair : pairs) {
            Integer x1 = pair.get(0);
            Integer x2 = pair.get(1);
            tempSet.add(s.substring(x1, x1+1));
            tempSet.add(s.substring(x2, x2+1));
            treeSet.add(x1);
            treeSet.add(x2);
        }
        Integer[] index = treeSet.toArray(new Integer[0]);
        String[] indexValue = tempSet.toArray(new String[0]);
        for (int i = 0, j = 0; i < length && j < index.length; i++) {
            if (i < index[j]) {
                res.append(s, i, index[j]);
                res.append(indexValue[j]);
                i = j++;
            } else {
                res.append(indexValue[j++]);
            }
        }
        return res.toString();
    }
    public List<Integer> addToArrayForm(int[] A, int K) {
        ArrayList<Integer> res = new ArrayList<>();
        StringBuilder tmp = new StringBuilder(A.length);
        for (int i : A) {
            tmp.append(i);
        }
        int resValue = Integer.parseInt(tmp.toString()) + K;
        while (resValue != 0){
            res.add(resValue % 10);
            resValue /= 10;
        }
        Collections.reverse(res);
        return res;
    }
}
