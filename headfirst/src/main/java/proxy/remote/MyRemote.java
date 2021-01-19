package proxy.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author wy
 * @date 2020/11/16
 */
public interface MyRemote extends Remote {

    public String sayHello() throws RemoteException;
}
