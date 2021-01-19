package factory.realfactory.chicago;


import factory.realfactory.Pizza;

public class ChicagoStylePepperoniPizza extends Pizza {
    public ChicagoStylePepperoniPizza() {
        super.name = "NY Style Sauce and pepperoni Pizza";
        super.dough = "Extra Thick Crust Dough";
        super.sauce = "Plum Tomato Sauce";

        super.toppings.add("Shredded Mozzarella pepperoni");
    }

    @Override
    protected void cut() {
        System.out.println("Cutting the pizza into square slices");
    }

}
