package factory.pizzaaf;

import factory.pizzaaf.ingredient.impl.NYPizzaIngredientFactory;

public class PepperoniPizza extends Pizza {
    private NYPizzaIngredientFactory ingredientFactory;

    public PepperoniPizza(NYPizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
        pepperoni = ingredientFactory.createPepperoni();
    }
}
