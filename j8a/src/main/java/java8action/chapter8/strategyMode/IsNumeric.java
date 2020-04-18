package java8action.chapter8.strategyMode;

/**
 * 判断数字
 *
 * @author
 * @create 2020-04-12 21:59
 */
public class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
