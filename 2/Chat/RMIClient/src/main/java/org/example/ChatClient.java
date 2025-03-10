package org.example;

import java.rmi.Naming;
import java.util.Scanner;

public class ChatClient {
    public static void main (String[] argv) {
        try {
            System.setProperty("java.security.policy", "security.policy");
            System.setSecurityManager(new SecurityManager());

            Scanner scanner = new Scanner(System.in);

            System.out.print("Wpisz login: ");
            String name = scanner.nextLine();

            ChatInterface client = new Chat(name);
            ChatInterface server = (ChatInterface) Naming.lookup("//localhost/ABC");

            server.setClient(client);
            server.send("Połączono: [" + client.getName() + "]");

            while(true){
                String newMessage = scanner.nextLine();
                server.send("[" + client.getName() + "] " + newMessage);
            }

        } catch (Exception ex) {
            System.out.println("Błąd: "  +  ex);
        }
    }
}