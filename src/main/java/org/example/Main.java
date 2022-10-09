package org.example;


public class Main {
    public static void swap(Employee x,Employee y)
    {
        Employee temp = x;
        x=y;
        y=temp;
    }

    public static void main(String[] args) {
        Employee employee1=new Employee("张三");
        Employee employee2=new Employee("李四");
        System.out.println(employee1);
        System.out.println(employee1.name);
        System.out.println(employee2);
        System.out.println(employee2.name);

        swap(employee1, employee2);
        System.out.println(employee1);
        System.out.println(employee1.name);
        System.out.println(employee2);
        System.out.println(employee2.name);

        Integer i1=100;
        System.out.println(i1);
        i1=i1*2;
        System.out.println(i1);

    }
}