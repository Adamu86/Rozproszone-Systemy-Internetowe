package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MyServerMain {
    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "security.policy");

            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }

            System.setProperty("java.rmi.server.codebase","file:/C:/Users/User/Documents/AdamkaRzeczy/GitHub/RSI/Rozproszone-Systemy-Internetowe/1/Base/RMIServer/target/classes/org/example");

            System.out.println("Codebase: " + System.getProperty("java.rmi.server.codebase"));

            LocateRegistry.createRegistry(1099);

            MyServerImpl obj1 = new MyServerImpl();

            Naming.rebind("//localhost/ABC", obj1);

            System.out.println("Serwer oczekuje ...");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
