package proxy.gumballRemote;

import java.io.Serializable;

/**
 * @author wy
 * @date 2020/11/16
 */
public interface State extends Serializable {
    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
}
