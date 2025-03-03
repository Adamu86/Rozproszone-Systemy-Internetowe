package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyServerImpl extends UnicastRemoteObject implements MyServerInt {
    int i = 0;

    protected MyServerImpl() throws RemoteException {
        super();
    }

    @Override
    public String getDescription(String text) throws RemoteException {
        i++;

        System.out.println("MyServerImpl.getDescription: " + text + " " + i);

        return "getDescription: " + text + " " + i;
    }


    // Implementacja metod kalkulatora
    @Override
    public String addNumbers(double a, double b) throws RemoteException {
        String result = "Wynik dodawania: " + (a + b);
        System.out.println(result);
        return result;
    }

    @Override
    public String subtractNumbers(double a, double b) throws RemoteException {
        String result = "Wynik odejmowania: " + (a - b);
        System.out.println(result);
        return result;
    }

    @Override
    public String multiplyNumbers(double a, double b) throws RemoteException {
        String result = "Wynik mnożenia: " + (a * b);
        System.out.println(result);
        return result;
    }

    @Override
    public String divideNumbers(double a, double b) throws RemoteException {
        if (b == 0) {
            String errorResult = "Błąd: dzielenie przez zero.";
            System.out.println(errorResult);
            return errorResult;
        }
        String result = "Wynik dzielenia: " + (a / b);
        System.out.println(result);
        return result;
    }
}
