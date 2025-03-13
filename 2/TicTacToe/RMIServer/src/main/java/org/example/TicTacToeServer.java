package org.example;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class TicTacToeServer {
    public static void main (String[] argv) {
        try {
            System.setProperty("java.security.policy", "security.policy");
            System.setSecurityManager(new SecurityManager());

            LocateRegistry.createRegistry(1099);

            TicTacToe server = new TicTacToe();
            Naming.rebind("//localhost/ABC", server);

            System.out.print("Serwer uruchomiony.\n");
        } catch (Exception ex) {
            System.out.println("Błąd: " + ex);
        }
    }
}
