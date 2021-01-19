package state.gumballstate;

/**
 * @author wy
 * @date 2020/11/13
 */
public interface State {

    /**
     * 投币
     */
    void insertQuarter();

    /**
     * 出糖果
     */
    void ejectQuarter();

    /**
     * 扭动
     */
    void turnCrank();

    /**
     * 出糖果
     */
    void dispense();
}
