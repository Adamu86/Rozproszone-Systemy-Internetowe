package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyServerImpl extends UnicastRemoteObject implements MyServerInt {
    int i = 0;

    protected MyServerImpl() throws RemoteException {
        super();
    }

    @Override
    public String getDescription(String text) throws RemoteException {
        i++;

        System.out.println("MyServerImpl.getDescription: " + text + " " + i);

        return "getDescription: " + text + " " + i;
    }
}
