package factory.pizza.realfactory.newyork;


import factory.pizza.realfactory.Pizza;

public class NYStyleVeggiePizza extends Pizza {
    public NYStyleVeggiePizza() {
        super.name = "NY Style Sauce and Veggie Pizza";
        super.dough = "Thin Crust Dough";
        super.sauce = "Marinara Sauce";

        super.toppings.add("Grated Reggiano Veggie");
    }
}
