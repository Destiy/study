package factory.pizza.realfactory.chicago;


import factory.pizza.realfactory.Pizza;

public class ChicagoStyleClamPizza extends Pizza {
    public ChicagoStyleClamPizza() {
        super.name = "NY Style Sauce and Clam Pizza";
        super.dough = "Extra Thick Crust Dough";
        super.sauce = "Plum Tomato Sauce";

        super.toppings.add("Shredded Mozzarella Clam");
    }

    @Override
    protected void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
