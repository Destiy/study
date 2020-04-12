package java8Action.chapter8.chainResponsibilityMode;

/**
 * @author
 * @create 2020-04-13 0:19
 */
public class SpellCheckerProcessing<T> extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return input.replaceAll("labda", "lambda");
    }
}
