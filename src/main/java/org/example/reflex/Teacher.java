package org.example.reflex;

public class Teacher {
    //三个成员变量，一个私有、一个默认、一个公有
    private String name;
    int age;
    public String address;

    //三个构造方法，一个默认、两个公有
    public Teacher(){}

    private Teacher(String name){
        this.name=name;
    }

   Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Teacher(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    //成员函数：一个私有，四个公有
    private void function(){System.out.println("function");}

    public void method1(){System.out.println("method");}

    public void method2(String s){System.out.println("method:"+s);}

    @Override
    public String toString(){
        return "Teacher{"+
                "name="+name+'\''+
                ",age="+age+
                ",address="+address+'\''+'}';
    }


}
