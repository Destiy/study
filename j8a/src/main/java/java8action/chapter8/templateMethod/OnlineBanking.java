package java8action.chapter8.templateMethod;

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
