package org.example.product;

public class Customer implements Runnable{
    private Box box;
    public Customer(Box box) {
        this.box=box;
    }

    @Override
    public void run(){
        while(true){
            box.get();
        }
    }
}
