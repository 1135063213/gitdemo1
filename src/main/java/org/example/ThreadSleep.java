package org.example;

public class ThreadSleep extends Thread{
    ThreadSleep(){}
    ThreadSleep(String name){
        super(name);
    }
    @Override
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println(getName()+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
