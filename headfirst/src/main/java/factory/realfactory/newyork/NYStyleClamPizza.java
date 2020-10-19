package factory.realfactory.newyork;


import factory.realfactory.Pizza;

public class NYStyleClamPizza extends Pizza {
    public NYStyleClamPizza() {
        super.name = "NY Style Sauce and Clam Pizza";
        super.dough = "Thin Crust Dough";
        super.sauce = "Marinara Sauce";

        super.toppings.add("Grated Reggiano Clam");
    }
}
