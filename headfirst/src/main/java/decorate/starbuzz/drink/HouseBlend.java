package decorate.starbuzz.drink;

import decorate.starbuzz.decorator.Beverage;

/**
 * 综合咖啡
 * @author wy
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        super.description = "HouseBlend";
    }

    @Override
    public double cost() {
        return .89;
    }
}
