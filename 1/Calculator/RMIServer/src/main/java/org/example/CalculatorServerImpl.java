package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServerImpl extends UnicastRemoteObject implements CalculatorServerInt {
    private double num1, num2, result;

    protected CalculatorServerImpl() throws RemoteException {
        super();
    }

    @Override
    public void insertFirstNumber(String number) throws RemoteException {
        this.num1 = parseNumber(number);
        System.out.println("Pierwsza dodana liczba: " + number);
    }

    @Override
    public void insertSecondNumber(String number) throws RemoteException {
        this.num2 = parseNumber(number);
        System.out.println("Druga dodana liczba: " + number);
    }

    @Override
    public String insertOperator(String operator) throws RemoteException {
        switch (operator) {
            case "+":
                this.result = this.num1 + this.num2;
                break;
            case "-":
                this.result = this.num1 - this.num2;
                break;
            case "*":
                this.result = this.num1 * this.num2;
                break;
            case "/":
                this.result = this.num1 / this.num2;
                break;
            default:
                return "Niedozwolona operacja.";
        }

        System.out.println("Działanie: " + operator);

        String res = "Wynik działania (" + num1 + " " + operator + " " + num2 + "): " + result;

        System.out.println(res + "\n\n");

        return res;
    }

    double parseNumber(String number) throws RemoteException {
        number = number.replaceAll("[^0-9.-]", "");

        return Double.parseDouble(number);
    }
}
