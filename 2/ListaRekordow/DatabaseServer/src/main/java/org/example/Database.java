package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Database extends UnicastRemoteObject implements IDatabase {
    private List<Product> products;

    public Database() throws RemoteException {
        super();

        this.products = new ArrayList<>();

        generateData();
    }

    @Override
    public List<Product> findAll() throws RuntimeException {
        System.out.println("Znalezione produkty: " + products);
        return products;
    }

    @Override
    public Product findByName(String name) throws RuntimeException {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                System.out.println("Znaleziono produkt: " + product);
                return product;
            }
        }

        throw new RuntimeException("Produkt o nazwe " + name + " nie istnieje.");
    }

    public void generateData() throws RuntimeException {
        this.products = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            products.add(new Product("Product " + i, i * 10.0));
        }
    }
}
