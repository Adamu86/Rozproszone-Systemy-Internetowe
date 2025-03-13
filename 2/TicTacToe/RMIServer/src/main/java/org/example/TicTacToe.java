package org.example;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToe extends UnicastRemoteObject implements TicTacToeInt  {
    private final int[][] board;
    private final List<TicTacToeInt> players;
    private String turn;

    public TicTacToe() throws RemoteException {
        this.board = new int[3][3];
        this.players = new ArrayList<>();
    }

    @Override
    public void setPlayer(TicTacToeInt player) throws RemoteException {
        if (players.size() < 2) {
            System.out.println("Połączono gracza " + (this.players.size() + 1) + ".");

            this.players.add(player);

            switch (this.players.size()) {
                case 1 :
                    this.players.get(0).displayTurn("Połączono jako Gracz 1 (Krzyżyk)");
                    break;
                case 2 :
                    this.players.get(1).displayTurn("Połączono jako Gracz 2 (Kółko)");
                    break;
            }

            if (players.size() == 2) {
                System.out.println("Połączono dwóch graczy. Rozpoczynanie rozgrywki.");

                initializeBoard();

                turn = (new Random()).nextInt(2) == 1 ? "Gracz 1" : "Gracz 2";

                displayTurn("Kolej: " + turn + " " + (turn.equals("Gracz 1") ? "(X)" : "(O)"));
                displayBoard(this.board);
                displaySetMove();
            }
        }
    }

    @Override
    public void setMove(int x, int y) throws RemoteException {
        if (this.players.size() < 2) {
            displayTurn("Poczekaj na drugiego gracza.");
            return;
        }

        if (this.board[x][y] == 1 || this.board[x][y] == 2) {
            displayTurn("Kolej: " + turn + " " + (turn.equals("Gracz 1") ? "(X)" : "(O)"));
            displayBoard(this.board);
            displaySetMove();
            return;
        }

        switch (turn) {
            case "Gracz 1" :
                this.board[x][y] = 1;
                this.turn = "Gracz 2";
                break;
            case "Gracz 2" :
                this.board[x][y] = 2;
                this.turn = "Gracz 1";
                break;
        }

        if (check() == 1) {
            displayTurn("Wygrywa Gracz 1");
            displayBoard(this.board);
        } else if (check() == 2) {
            displayTurn("Wygrywa Gracz 2");
            displayBoard(this.board);
        } else {
            displayTurn("Kolej: " + turn + " " + (turn.equals("Gracz 1") ? "(X)" : "(O)"));
            displayBoard(this.board);
            displaySetMove();
        }
    }

    @Override
    public void displayBoard(int[][] board) throws RemoteException {
        for (TicTacToeInt player : players) {
            player.displayBoard(board);
        }
    }

    @Override
    public void displayTurn(String turn) throws RemoteException {
        for (TicTacToeInt player : players) {
            player.displayTurn(turn);
        }
    }

    @Override
    public void displaySetMove() throws RemoteException {
        switch (turn) {
            case "Gracz 1" :
                this.players.get(0).displaySetMove();
                break;
            case "Gracz 2" :
                this.players.get(1).displaySetMove();
                break;
        }
    }

    private void initializeBoard() {
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                this.board[i][j] = 0;
            }
        }
    }

    public int check() {
        if (diagonal(1)) return 1;
        else if (diagonal(2)) return 2;

        for (int i = 0 ; i < 3 ; i++) {
            int ver1 = 0, ver2 = 0, hor1 = 0, hor2 = 0;

            for (int j = 0 ; j < 3 ; j++) {
                hor1 += board[i][j] == 1 ? 1 : 0;
                ver1 += board[j][i] == 1 ? 1 : 0;
                hor2 += board[i][j] == 2 ? 1 : 0;
                ver2 += board[j][i] == 2 ? 1 : 0;
            }

            if (ver1 == 3 || hor1 == 3) return 1;
            if (ver2 == 3 || hor2 == 3) return 2;
        }

        return -1;
    }

    private boolean diagonal(int i) {
        return (board[1][1] == i && ((board[0][0] == i && board[2][2] == i) || (board[2][0] == i && board[0][2] == i)));
    }
}