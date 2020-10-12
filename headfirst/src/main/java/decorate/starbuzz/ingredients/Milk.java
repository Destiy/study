package decorate.starbuzz.ingredients;

import decorate.starbuzz.decorator.Beverage;
import decorate.starbuzz.decorator.CondimentDecorator;

/**
 * 牛奶
 *
 * @author wy
 */
public class Milk extends CondimentDecorator {
    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
