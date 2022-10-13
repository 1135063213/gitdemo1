package org.example.Animal;

public class AnimalOperator {
    //多态提高了程序的扩展性，Animal a作为方法参数，执行时看具体指向子类对象重写的方法
    //弊端是无法父类引用无法访问子类独有的方法
    public void useAnimal(Animal a){ //Animal a=new Dog();
        a.eat();
        //a.lookDoor();//错误，父类引用无法访问子类独有的方法
        Dog dog=(Dog)a;
        dog.lookDoor();//可通过强制转型访问子类独有方法

        //向上转型
        a=new Cat();
        a.eat();
    }
}
