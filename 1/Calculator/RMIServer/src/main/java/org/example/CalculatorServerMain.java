package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class CalculatorServerMain {
    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "security.policy");

            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }

            LocateRegistry.createRegistry(1099);

            CalculatorServerImpl obj1 = new CalculatorServerImpl();

            Naming.rebind("//localhost/ABC", obj1);

            System.out.println("Serwer oczekuje ...");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
