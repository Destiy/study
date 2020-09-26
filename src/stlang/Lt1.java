package stlang;

/**
 * @author wy
 * @data 2020-09-12 16:47
 */
public class Lt1 {

    public static void main(String[] args) {
        String str = "ryyryyyrryyyyyryyyrrryyyryryyyyryyrrryryyyryrryrrrryyyrrrrryryyrrrrryyyryyryrryryyryyyyryyrryrryryy";
        System.out.println(test(str));
    }

    public static Integer test(String leaves) {

        int result = 0;
        int rs = 0, ys = 0;
        int l = 0, r = leaves.length() - 1;
        if (leaves.charAt(l) == 'y') {
            l ++;
            result++;
        }
        if (leaves.charAt(r) == 'y') {
            r--;
            result++;
        }
        String substring = leaves.substring(l, r);
        if (!substring.contains("y")) {
            return ++result;
        }
        for (int i = l; i <= r; i++) {
            if (leaves.charAt(i) != 'r') {
                l = i;
                break;
            }
        }
        for (int i = r; i >= 0; i--) {
            if (leaves.charAt(i) != 'r') {
                r = i;
                break;
            }
        }

        for (int i = l; i <= r; i++) {
            if (leaves.charAt(i) == 'r' && ys != 0) {
                rs++;
            } else if (leaves.charAt(i) == 'y'){
                ys++;
            }
            if (rs > 0 && rs == ys){
                int t= rs;
                result += t;
                rs -= t; ys -= t;
            }
        }

        return result + Math.min(rs,ys);
    }

}
