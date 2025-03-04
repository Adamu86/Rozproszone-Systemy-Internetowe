package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyServerInt extends Remote{
    String performCalculation(String operation) throws RemoteException;
}

