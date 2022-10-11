package org.example.product;

public class Box {
    //表示第几瓶奶
    private int milk;
    private boolean state=false;

    public synchronized void put(int milk){
        //如果有牛奶，等待消费
        if(state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果没有牛奶，生产牛奶
        this.milk=milk;
        System.out.println("送奶工将第"+milk+"瓶奶放入奶箱");

        //生产完毕后，修改奶箱状态
        state=true;

        //唤醒其他线程
        notifyAll();
    }

    public synchronized void get(){
        //如果没有牛奶，等待生产
        if(!state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果有牛奶，消费牛奶
        System.out.println("用户拿到第"+milk+"瓶奶");

        //修改牛奶状态
        state=false;

        //唤醒其他线程
        notifyAll();
    }
}
