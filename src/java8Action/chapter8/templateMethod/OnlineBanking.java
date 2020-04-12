package java8Action.chapter8.templateMethod;

import java.util.function.Consumer;

/**
 * 模板方法
 *
 * @author
 * @create 2020-04-12 22:27
 */
abstract class OnlineBanking {

    public void processCustomer(int id) {
        Customer c = new Customer();
        c.setName("张三");
        makeCustomerHappy(c);
    }

    abstract void makeCustomerHappy(Customer c);

}
