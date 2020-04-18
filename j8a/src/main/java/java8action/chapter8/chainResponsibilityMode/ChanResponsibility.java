package java8action.chapter8.chainResponsibilityMode;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author
 * @create 2020-04-13 0:21
 */
public class ChanResponsibility {

    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing<>();
        ProcessingObject<String> p2 = new SpellCheckerProcessing<>();
        // 连接对象
        p1.setSuccessor(p2);

        String result = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);

        // TODO Lambda 版本
        UnaryOperator<String> headerProcessing =
                (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing =
                (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
        System.out.println(pipeline.apply("Aren't labdas really sexy?!!"));
    }
}
