package factory.pizza.realfactory.newyork;


import factory.pizza.realfactory.Pizza;

public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        super.name = "NY Style Sauce and Cheese Pizza";
        super.dough = "Thin Crust Dough";
        super.sauce = "Marinara Sauce";

        super.toppings.add("Grated Reggiano Cheese");
    }
}
