package io.ollg.store.model;

public class CartItem {
    private Product product;
    private int amount;

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

    public void setAmount(int amount){
        this.amount = amount;
    }
}
