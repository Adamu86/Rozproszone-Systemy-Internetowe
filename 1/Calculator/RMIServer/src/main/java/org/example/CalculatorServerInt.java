package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorServerInt extends Remote{
    void insertFirstNumber(String number) throws RemoteException;
    void insertSecondNumber(String number) throws RemoteException;
    String insertOperator(String operator) throws RemoteException;
}

