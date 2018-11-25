package io.ollg.store.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {

    Library library = Library.getInstance();
    Map <Integer, CartItem> map;

    public Cart() {
        map = new HashMap<>();
    }

    public List<CartItem> getItems(){
        return map.values().stream().collect(Collectors.toList());
    }

    public void addProduct(Integer id, Integer amount){

        if(library.getProductById(id) == null){
            throw new RuntimeException("W metodzie addProduct() podano id nieistniejacego produktu.");
        }
        if (map.containsKey(id)){
            map.get(id).increaseAmount(amount);
        }else {
            map.put(id, new CartItem(library.getProductById(id), amount));
        }
    }

    public void  setAmount(Integer id, Integer newAmount){
        if(map.get(id) != null){
            map.get(id).setAmount(newAmount);
        }else {
            throw  new RuntimeException("Podano niepoprawne id, przy metodzie 'setAmount(id, newAmount)'");
        }
    }

    public void removeProduct(Integer id){
        map.remove(id);
    }
}
