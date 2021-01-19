package decorate.starbuzz.ingredients;

import decorate.starbuzz.decorator.Beverage;
import decorate.starbuzz.decorator.CondimentDecorator;

/**
 * 摩卡
 *
 * @author wy
 */
public class Mocha extends CondimentDecorator {

    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
