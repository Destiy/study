package templatemethod.barista;

/**
 * @author wy
 * @date 2020/11/09
 */
public abstract class CaffeineBeverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    /**
     * 泡茶
     */
    abstract void brew();

    /**
     * 添加材料
     */
    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
