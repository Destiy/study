package factory.pizza.factory;

public interface Pizza {

    /**
     * 准备
     */
    void prepare();

    /**
     * 烤
     */
    void bake();

    /**
     * 切
     */
    void cut();

    /**
     * 打包
     */
    void box();
}
