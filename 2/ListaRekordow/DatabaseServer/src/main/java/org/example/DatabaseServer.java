package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class DatabaseServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        System.setProperty("java.security.policy", "security.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        LocateRegistry.createRegistry(1099);

        Database db = new Database();

        Naming.rebind("//localhost/ABC", db);

        System.out.println("Serwer oczekuje ...");
    }
}