package decorate.starbuzz;

import decorate.starbuzz.decorator.Beverage;
import decorate.starbuzz.drink.DarkRoast;
import decorate.starbuzz.drink.Espresso;
import decorate.starbuzz.drink.HouseBlend;
import decorate.starbuzz.ingredients.Mocha;
import decorate.starbuzz.ingredients.Soy;
import decorate.starbuzz.ingredients.Whip;

public class StarBuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Soy(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
