package java8action.chapter8.chainResponsibilityMode;

/**
 * @author
 * @create 2020-04-13 0:18
 */
public class HeaderTextProcessing<T> extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return "From Raoul, Mario and Alan: " + input;
    }
}
