package io.ollg.store.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cart {

    Library library = Library.getInstance();
    List<CartItem> items = new ArrayList<>();

    public void addProduct(Integer id, Integer amount){
        Product product = library.getProductById(id);

        //if(items.contains())
    }


}
