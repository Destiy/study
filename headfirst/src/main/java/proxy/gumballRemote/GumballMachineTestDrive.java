package proxy.gumballRemote;

import java.rmi.RemoteException;

/**
 * @author wy
 * @date 2020/11/16
 */
public class GumballMachineTestDrive {

    public static void main(String[] args) {
        GumballMachineRemote gumballMachine = null;
        int count;
        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        count = Integer.parseInt("1");
        try {
            GumballMachine gumballMachine1 = new GumballMachine(args[0], count);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
