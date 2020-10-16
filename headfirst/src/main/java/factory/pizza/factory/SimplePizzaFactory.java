package factory.pizza.factory;

import factory.pizza.CheesePizza;
import factory.pizza.ClamPizza;
import factory.pizza.VeggiePizza;

/**
 * 工厂
 * @author wy
 */
public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if ("cheese".equals(type)){
            pizza = new CheesePizza();
        } else if ("clam".equals(type)) {
            pizza = new ClamPizza();
        } else if ("veggie".equals(type)) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
