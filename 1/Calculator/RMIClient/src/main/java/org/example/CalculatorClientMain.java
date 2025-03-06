package org.example;


import java.rmi.Naming;
import java.util.Scanner;

public class CalculatorClientMain {
    public static void main(String[] args) {
        System.setProperty("java.security.policy", "security.policy");

        System.setSecurityManager(new SecurityManager());

        try {
            CalculatorServerInt remoteCalculator = (CalculatorServerInt) Naming.lookup("//localhost/ABC");

            Scanner scanner = new Scanner(System.in);
            boolean run = true;

            while (run) {
                clear();

                System.out.print("Wprowadź pierwszą liczbę: ");
                remoteCalculator.insertFirstNumber(scanner.next());

                System.out.print("Wprowadź drugą liczbę: ");
                remoteCalculator.insertSecondNumber(scanner.next());

                System.out.print("Działanie (+, -, *, /): ");
                String result = remoteCalculator.insertOperator(scanner.next());

                System.out.print(result + "\n\n" + "Naciśnij ENTER, aby kontynuować...\n");
                scanner.nextLine();
                scanner.nextLine();
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}