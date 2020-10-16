package factory.pizza;

import factory.pizza.factory.Pizza;
import factory.pizza.factory.SimplePizzaFactory;

public class PizzaStore {
    private SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza main(String type) {
        Pizza pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.box();

        return pizza;
    }
}
