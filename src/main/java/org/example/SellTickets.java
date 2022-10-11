package org.example;

public class SellTickets implements Runnable{
    private static int tickets=100;
    private Object obj=new Object();
    private int x=0;

    @Override
    public void run(){
        while(true){
            if(x%2==0) {
//              synchronized (obj) {
//              synchronized (this) {
                synchronized (SellTickets.class) {
                    if (tickets > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ":" + tickets);
                        tickets--;
                    }
                }
            }else{
                sellTicket();
            }
            x++;
        }
    }

    private static synchronized void sellTicket() {
        if (tickets > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + tickets);
            tickets--;
        }
    }
}
