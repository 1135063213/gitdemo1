package org.example.lambdademo;

@FunctionalInterface
public interface StudentBuilder {
    Student build(String name,int age);
}
