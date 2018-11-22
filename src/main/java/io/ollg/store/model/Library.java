package io.ollg.store.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private Map<Integer, Product> products;
    private Integer nextId;

    public List<Product> getProducts(){
        return new ArrayList<>(products.values());
    }

    public Product getProductById(Integer id){
        return products.get(id);
    }

    public Integer addNewProduct(String name, int price){
        Integer id = generateNextId();
        products.put(id, new Product(id, name, price));
        return id;
    }

    private Integer generateNextId(){
        return nextId++;
    }

    private static Library instance = new Library();
    public static Library getInstance(){
        return instance;
    }
    private Library(){
        //odczyt z pliku
        products = new HashMap<>();
        nextId = 0;
    }
}
