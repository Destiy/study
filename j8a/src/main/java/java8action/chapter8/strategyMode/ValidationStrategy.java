package java8action.chapter8.strategyMode;

/**
 * @author
 * @create 2020-04-12 21:58
 */
public interface ValidationStrategy {
    boolean execute(String s);
}
