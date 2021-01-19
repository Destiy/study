package proxy.gumballRemote;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author wy
 * @date 2020/11/16
 */
public interface GumballMachineRemote extends Remote {

    public int getCount() throws RemoteException;
    public String getLocation() throws RemoteException;
    public State getState() throws RemoteException;
}
