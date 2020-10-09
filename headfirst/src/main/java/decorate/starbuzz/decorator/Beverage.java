package decorate.starbuzz.decorator;

/**
 * 基类
 */
public abstract class Beverage {
    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    /**
     * 价格计算
     * @return  price
     */
    public abstract double cost();
}
