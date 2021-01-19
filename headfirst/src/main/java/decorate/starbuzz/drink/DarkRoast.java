package decorate.starbuzz.drink;

import decorate.starbuzz.decorator.Beverage;

/**
 * 深焙咖啡
 * @author wy
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        super.description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return .99;
    }
}
