package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TicTacToeInt extends Remote {
    void setPlayer(TicTacToeInt player) throws RemoteException;
    void setMove(int x, int y, int id) throws RemoteException;
    void displayBoard(int[][] board) throws RemoteException;
    void displayTurn(String turn) throws RemoteException;
    void displaySetMove() throws RemoteException;
    int getId() throws RemoteException;
}