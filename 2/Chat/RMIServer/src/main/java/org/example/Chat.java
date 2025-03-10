package org.example;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;

public class Chat extends UnicastRemoteObject implements ChatInterface  {
    public String name;
    public List<ChatInterface> clients;
    public List<String> messages;

    public Chat(String name)  throws RemoteException {
        this.name = name;
        this.clients = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    @Override
    public String getName() throws RemoteException {
        return this.name;
    }

    @Override
    public void setClient(ChatInterface client) throws RemoteException {
        this.clients.add(client);

        for (String message : messages) {
            client.send(message);
        }
    }

    @Override
    public List<ChatInterface> getClients(){
        return this.clients;
    }

    @Override
    public void send(String message) throws RemoteException {
        this.messages.add(message);

        System.out.println(message);

        for (ChatInterface client : clients) {
            client.send(message);
        }
    }
}