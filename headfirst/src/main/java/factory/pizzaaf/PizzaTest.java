package factory.pizzaaf;

public class PizzaTest {

    public static void main(String[] args) {
        NYPizzaStore nyPizzaStore = new NYPizzaStore();

        Pizza pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");
    }
}
