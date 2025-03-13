package org.example;

import java.rmi.Naming;

public class DatabaseClient {
    public static void main(String[] args) {
        System.setProperty("java.security.policy", "security.policy");

        System.setSecurityManager(new SecurityManager());

        try {
            IDatabase remoteCalculator = (IDatabase) Naming.lookup("//localhost/ABC");

            System.out.println(remoteCalculator.findAll());

            System.out.println(remoteCalculator.findByName("Product 5"));

            System.out.println(remoteCalculator.findByName("Product 21"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}