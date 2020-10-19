package factory.pizza.realfactory.chicago;

import factory.pizza.realfactory.Pizza;

public class ChicagoStyleVeggiePizza extends Pizza {
    public ChicagoStyleVeggiePizza() {
        super.name = "NY Style Sauce and veggie Pizza";
        super.dough = "Extra Thick Crust Dough";
        super.sauce = "Plum Tomato Sauce";

        super.toppings.add("Shredded Mozzarella veggie");
    }

    @Override
    protected void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
