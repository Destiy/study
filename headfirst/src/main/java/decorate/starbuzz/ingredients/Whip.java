package decorate.starbuzz.ingredients;

import decorate.starbuzz.decorator.Beverage;
import decorate.starbuzz.decorator.CondimentDecorator;

/**
 * 奶泡
 *
 * @author wy
 */
public class Whip extends CondimentDecorator {
    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return 0.1 + beverage.cost();
    }
}
