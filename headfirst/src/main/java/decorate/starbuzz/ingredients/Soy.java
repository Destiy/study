package decorate.starbuzz.ingredients;

import decorate.starbuzz.decorator.Beverage;
import decorate.starbuzz.decorator.CondimentDecorator;

/**
 * 豆浆
 *
 * @author wy
 */
public class Soy extends CondimentDecorator {
    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return .15 + beverage.cost();
    }
}
