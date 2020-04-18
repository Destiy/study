package java8action.chapter8.strategyMode;

/**
 * 策略模式
 *
 * @author
 * @create 2020-04-12 21:57
 */
public class Validator {

    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy v) {
        this.strategy = v;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }

    public static void main(String[] args) {
        Validator numericValidator1 = new Validator(new IsNumeric());
        boolean a1 = numericValidator1.validate("aaaa");
        Validator lowerCaseValidator1 = new Validator(new IsAllLowerCase());
        boolean b1 = lowerCaseValidator1.validate("bbbb");
        System.out.println("IsNumeric = " + a1);
        System.out.println("IsAllLowerCase = " + b1);

        // TODO Lambda 表达式
        Validator numericValidator = new Validator(s -> s.matches("\\d+"));
        boolean a2 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator2 = new Validator(s -> s.matches("[a-z]+"));
        boolean b2 = lowerCaseValidator2.validate("bbbb");
        System.out.println("Lambda numericValidator = " + a2);
        System.out.println("Lambda lowerCaseValidator = " + b2);

    }
}
