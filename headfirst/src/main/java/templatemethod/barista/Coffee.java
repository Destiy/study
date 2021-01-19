package templatemethod.barista;

/**
 * @author wy
 * @date 2020/11/09
 */
public class Coffee extends CaffeineBeverage{
    @Override
    public void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
