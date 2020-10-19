package factory.pizzaaf;

import factory.pizzaaf.ingredient.PizzaIngredientFactory;

public class ClamPizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("preparing " + name);
        super.dough = ingredientFactory.createDough();
        super.sauce = ingredientFactory.createSauce();
        super.cheese = ingredientFactory.createCheese();
        super.clam = ingredientFactory.createClam();
    }
}
