package decorate.starbuzz.drink;

import decorate.starbuzz.decorator.Beverage;

/**
 * 浓缩咖啡
 * @author wy
 */
public class Espresso extends Beverage {
    public Espresso() {
        super.description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
