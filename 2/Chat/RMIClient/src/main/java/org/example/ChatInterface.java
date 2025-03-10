package org.example;

import java.rmi.*;
import java.util.List;

public interface ChatInterface extends Remote{
    String getName() throws RemoteException;
    void send(String msg) throws RemoteException;
    void setClient(ChatInterface c)throws RemoteException;
    List<ChatInterface> getClients() throws RemoteException;
}