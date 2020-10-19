package factory.pizza.realfactory.newyork;

import factory.pizza.realfactory.Pizza;
import factory.pizza.realfactory.PizzaStore;

public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza;
        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        } else if (type.equals("veggie")) {
            pizza = new NYStyleVeggiePizza();
        } else if (type.equals("clam")) {
            pizza = new NYStyleClamPizza();
        } else if (type.equals("pepperoni")){
            pizza = new NYStylePepperoniPizza();
        } else {
            pizza = null;
        }
        return pizza;
    }
}
