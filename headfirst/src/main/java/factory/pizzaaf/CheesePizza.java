package factory.pizzaaf;

import factory.pizzaaf.ingredient.PizzaIngredientFactory;

public class CheesePizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("preparing " + super.name);
        super.dough = ingredientFactory.createDough();
        super.sauce = ingredientFactory.createSauce();
        super.cheese = ingredientFactory.createCheese();
    }
}
