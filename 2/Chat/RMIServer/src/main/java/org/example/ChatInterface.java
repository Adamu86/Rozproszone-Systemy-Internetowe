package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChatInterface extends Remote{
    String getName() throws RemoteException;
    void send(String message) throws RemoteException;
    void setClient(ChatInterface client)throws RemoteException;
    List<ChatInterface> getClients() throws RemoteException;
}