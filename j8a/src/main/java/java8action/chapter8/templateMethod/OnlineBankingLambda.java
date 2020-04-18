package java8action.chapter8.templateMethod;

import java.util.function.Consumer;

/**
 * lambda 模板方法
 *
 * @author
 * @create 2020-04-12 23:18
 */
public class OnlineBankingLambda {

    public void processCustomer(int id, Consumer<Customer> make) {
        Customer c = new Customer();
        c.setName("张三");
        make.accept(c);
    }

    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(1234, (Customer c) ->
                System.out.println("hello " + c.getName()));
    }
}
