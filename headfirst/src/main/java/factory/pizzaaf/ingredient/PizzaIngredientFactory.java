package factory.pizzaaf.ingredient;

public interface PizzaIngredientFactory {

    /**
     * 面团
     * @return
     */
    public Dough createDough();

    /**
     * 酱
     * @return
     */
    public Sauce createSauce();

    /**
     * 起司
     * @return
     */
    public Cheese createCheese();

    /**
     * 蔬菜
     * @return
     */
    public Veggies[] createVeggies();

    /**
     * 意大利香肠
     * @return
     */
    public Pepperoni createPepperoni();

    /**
     * 蛤蜊
     * @return
     */
    public Clams createClam();
}
