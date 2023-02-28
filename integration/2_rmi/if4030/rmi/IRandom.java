package if4030.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRandom extends Remote {
    void setBounds( int min, int max ) throws RemoteException;
    int nextRandom() throws RemoteException;
}
