package decorate.starbuzz.drink;

import decorate.starbuzz.decorator.Beverage;

/**
 * 低因咖啡
 *
 * @author wy
 */
public class Decaf extends Beverage {
    public Decaf() {
        super.description = "Decaf Coffee";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
