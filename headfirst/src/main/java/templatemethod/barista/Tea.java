package templatemethod.barista;

/**
 * @author wy
 * @date 2020/11/09
 */
public class Tea extends CaffeineBeverage {
    @Override
    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
