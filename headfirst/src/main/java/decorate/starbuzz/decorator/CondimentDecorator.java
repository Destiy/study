package decorate.starbuzz.decorator;

/**
 * 包装器
 * @author wy
 */
public abstract class CondimentDecorator extends Beverage {

    /**
     * 获取商品描述
     * @return  商品描述
     */
    @Override
    public abstract String getDescription();
}
