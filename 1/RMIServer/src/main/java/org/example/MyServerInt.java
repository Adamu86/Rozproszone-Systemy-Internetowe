package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyServerInt extends Remote{
    String getDescription(String text) throws RemoteException;

    // Metody kalkulatora
    String addNumbers(double a, double b) throws RemoteException;
    String subtractNumbers(double a, double b) throws RemoteException;
    String multiplyNumbers(double a, double b) throws RemoteException;
    String divideNumbers(double a, double b) throws RemoteException;
}

