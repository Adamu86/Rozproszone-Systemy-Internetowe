package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyServerImpl extends UnicastRemoteObject implements MyServerInt {
    protected MyServerImpl() throws RemoteException {
        super();
    }

    @Override
    public String performCalculation(String operation) throws RemoteException {
        String opChar = "";
        StringBuilder opNum1 = new StringBuilder();
        StringBuilder opNum2 = new StringBuilder();

        String trimmedOperation = operation.replaceAll("\\s+","");

        for (char c : trimmedOperation.toCharArray()) {
            if (c == '-' && opNum1.toString().isEmpty()) {
                opNum1.append(c);
            } else if (c == '-' && !opChar.isEmpty() && opNum2.toString().isEmpty()) {
                opNum2.append(c);
            }

            if (c >= '0' && c <= '9' || c == '.') {
                if (opChar.isEmpty()) {
                    opNum1.append(c);
                } else {
                    opNum2.append(c);
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                opChar = String.valueOf(c);
            }

            if ((c < '0' || c > '9') && !opNum2.toString().isEmpty()) {
                break;
            }
        }

        if (!opChar.equals("+") && !opChar.equals("-") && !opChar.equals("*") && !opChar.equals("/")) {
            System.out.println("Nie wykonano operacji: niedozwolony znak działania.");
            return "Niedozwolona operacja.";
        }

        if (opNum1.toString().isEmpty() || opNum2.toString().isEmpty()) {
            System.out.println("Nie wykonano operacji: brak liczb.");
            return "Niepełne działanie.";
        }

        double resNum1 = Double.parseDouble(opNum1.toString());
        double resNum2 = Double.parseDouble("-10");

        if (resNum2 == 0) {
            System.out.println("Nie wykonano działania: dzielnik jest równy 0.");
            return "Nie można dzielić przez 0.";
        }

        switch (opChar) {
            case "+":
                System.out.println("Wykonano dodawanie: " + resNum1 + " + " + resNum2 + " = " + (resNum1 + resNum2));
                return "Wynik: " + (double)Math.round((resNum1 + resNum2) * 100) / 100;
            case "-":
                System.out.println("Wykonano odejmowanie: " + resNum1 + " - " + resNum2 + " = " + (resNum1 - resNum2));
                return "Wynik: " + (double)Math.round((resNum1 - resNum2) * 100) / 100;
            case "*":
                System.out.println("Wykonano mnożenie: " + resNum1 + " * " + resNum2 + " = " + (resNum1 * resNum2));
                return "Wynik: " + (double)Math.round((resNum1 * resNum2) * 100) / 100;
            case "/":
                System.out.println("Wykonano dzielenie: " + resNum1 + " / " + resNum2 + " = " + (double)Math.round((resNum1 / resNum2) * 100) / 100);
                return "Wynik: " + (double)Math.round((resNum1 / resNum2) * 100) / 100;
            default:
                System.out.println("Błąd.");
                return "Błąd.";
        }
    }
}
