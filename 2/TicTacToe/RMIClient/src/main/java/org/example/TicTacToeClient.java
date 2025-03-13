package org.example;

import java.rmi.Naming;
import java.util.Scanner;

public class TicTacToeClient {
    public static void main (String[] argv) {
        try {
            System.setProperty("java.security.policy", "security.policy");
            System.setSecurityManager(new SecurityManager());

            Scanner scanner = new Scanner(System.in);

            TicTacToeInt client = new TicTacToe();
            TicTacToeInt server = (TicTacToeInt) Naming.lookup("//localhost/ABC");

            server.setPlayer(client);

            while (true) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                server.setMove(x, y);
            }

        } catch (Exception ex) {
            System.out.println("Błąd: "  +  ex);
        }
    }
}