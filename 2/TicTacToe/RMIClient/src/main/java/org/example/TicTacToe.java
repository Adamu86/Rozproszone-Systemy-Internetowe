package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class TicTacToe extends UnicastRemoteObject implements TicTacToeInt  {
    public TicTacToe() throws RemoteException { }

    @Override
    public void setPlayer(TicTacToeInt player) throws RemoteException { }

    @Override
    public int getId() throws RemoteException { return -1; }

    @Override
    public void setMove(int x, int y, int id) throws RemoteException { }

    @Override
    public void displayTurn(String turn) throws RemoteException {
        System.out.println("\n" + turn);
    }

    @Override
    public void displaySetMove() throws RemoteException {
        System.out.print("Wybierz wiersz i kolumnę: ");
    }

    @Override
    public void displayBoard(int[][] board) throws RemoteException {
        System.out.println("-------------------");
        System.out.print("       ");

        for (int i = 0 ; i < 3 ; i++) {
            System.out.print("(" + i + ") ");
        }

        System.out.println("\n");

        for (int i = 0 ; i < 3 ; i++) {
            System.out.print("(" + i + ")    ");
            for (int j = 0 ; j < 3 ; j++) {
                switch (board[i][j]) {
                    case 0 :
                        System.out.print("[ ] ");
                        break;
                    case 1 :
                        System.out.print("[X] ");
                        break;
                    case 2:
                        System.out.print("[O] ");
                        break;
                }
            }

            System.out.println();
        }

        System.out.println();
    }
}