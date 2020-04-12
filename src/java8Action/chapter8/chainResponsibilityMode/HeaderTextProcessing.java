package java8Action.chapter8.chainResponsibilityMode;

import java.time.temporal.Temporal;

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
