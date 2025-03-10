package org.example;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.util.*;

public class ChatServer {
    public static void main (String[] argv) {
        try {
            System.setProperty("java.security.policy", "security.policy");
            System.setSecurityManager(new SecurityManager());

            Scanner scanner = new Scanner(System.in);

            LocateRegistry.createRegistry(1099);

            ChatInterface server = new Chat("Serwer");
            Naming.rebind("//localhost/ABC", server);

            System.out.print("Serwer uruchomiony.\n");

            while (true) {
                String serverMessage = scanner.nextLine();

                for (ChatInterface client : server.getClients()) {
                    client.send("[Serwer] " + serverMessage);
                }

                System.out.println("[Serwer] " + serverMessage);
            }

        } catch (Exception ex) {
            System.out.println("Błąd: " + ex);
        }
    }
}
