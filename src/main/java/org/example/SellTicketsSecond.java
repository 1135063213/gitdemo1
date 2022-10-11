package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellTicketsSecond implements Runnable {
    private static int tickets=100;
    private Lock lock=new ReentrantLock();

    @Override
    public void run(){
        while(true) {
            try {
                //add sleep time
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                lock.lock();
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + tickets);
                    tickets--;
                }
            }finally {
                lock.unlock();
            }
        }
    }

}
