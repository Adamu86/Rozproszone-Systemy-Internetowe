package org.example;


import java.rmi.Naming;
import java.util.Scanner;

public class MyClientMain {
    public static void main(String[] args) {
        System.setProperty("java.security.policy", "security.policy");

        System.setSecurityManager(new SecurityManager());

        try {
            MyServerInt myRemoteObject = (MyServerInt) Naming.lookup("//localhost/ABC");

            Scanner scanner = new Scanner(System.in);
            boolean run = true;

            while (run) {
                clear();

                System.out.println("Wprowadź działanie w postaci [liczba1 {operacja (+ - * /)} liczba2]: ");

                String input = scanner.nextLine();

                if (input.contains("exit")) {
                    break;
                }

                String result = myRemoteObject.performCalculation(input);

                System.out.println(result + "\n\n" + "Naciśnij ENTER, aby kontynuować...");

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