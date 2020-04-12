package java8Action.chapter8.strategyMode;

/**
 * 判断字母
 *
 * @author
 * @create 2020-04-12 21:58
 */
public class IsAllLowerCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
