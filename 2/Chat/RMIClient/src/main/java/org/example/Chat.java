package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.List;

public class Chat extends UnicastRemoteObject implements ChatInterface  {
    public String name;
    public ChatInterface client;

    public Chat(String name)  throws RemoteException {
        this.name = name;
    }

    @Override
    public String getName() throws RemoteException {
        return this.name;
    }

    @Override
    public void setClient(ChatInterface client){
        this.client = client;
    }

    @Override
    public List<ChatInterface> getClients(){
        return Collections.singletonList(this.client);
    }

    @Override
    public void send(String message) throws RemoteException {
        System.out.println(message);
    }
}