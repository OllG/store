package io.ollg.store.model;

public class CartItem {
    Product product;
    int amount;

    public CartItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public void increaseAmount(int amount){
        this.amount += amount;
    }

    public void decreaseAmount(int amount){
        if(this.amount < amount) {
            this.amount=0;
        }else {
            this.amount -= amount;
        }
    }
}
