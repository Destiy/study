package factory.pizza.realfactory.newyork;


import factory.pizza.realfactory.Pizza;

public class NYStylePepperoniPizza extends Pizza {
    public NYStylePepperoniPizza() {
        super.name = "NY Style Sauce and pepp Pizza";
        super.dough = "Thin Crust Dough";
        super.sauce = "Marinara Sauce";

        super.toppings.add("Grated Reggiano Clam");
    }
}
