package org.example;


import java.rmi.Naming;

public class MyClientMain {
    public static void main(String[] args) {
        System.setProperty("java.security.policy", "security.policy");

        System.setSecurityManager(new SecurityManager());

        try {
            MyServerInt myRemoteObject = (MyServerInt) Naming.lookup("//localhost/ABC");

            String text = "Hallo :-)";

            String result = myRemoteObject.getDescription(text);

            System.out.println("Wysłano do servera: " + text);

            System.out.println("Otrzymana z serwera odpowiedź: " + result);


            String addResult = myRemoteObject.addNumbers(5.0, 3.0);
            String subtractResult = myRemoteObject.subtractNumbers(5.0, 3.0);
            String multiplyResult = myRemoteObject.multiplyNumbers(5.0, 3.0);
            String divideResult = myRemoteObject.divideNumbers(5.0, 3.0);

            System.out.println(addResult);
            System.out.println(subtractResult);
            System.out.println(multiplyResult);
            System.out.println(divideResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}