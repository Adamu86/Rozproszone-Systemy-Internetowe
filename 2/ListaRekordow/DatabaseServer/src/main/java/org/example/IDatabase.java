package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IDatabase extends Remote {
    List<Product> findAll() throws RemoteException;
    Product findByName(String name) throws RemoteException;
}
