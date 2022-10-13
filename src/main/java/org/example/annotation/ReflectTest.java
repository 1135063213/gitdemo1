package org.example.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Pro(className = "org.example.reflex.Teacher",methodName = "method1")
public class ReflectTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        //1.解析注解
        Class<ReflectTest> c = ReflectTest.class;//获取该类的字节码对象
        Pro an = c.getAnnotation(Pro.class);//获取上面的注解对象
        String className=an.className();//获取注解className属性
        String methodName=an.methodName();//获取注解methodName属性

        Class<?> aClass1 = Class.forName(className); //获取要使用类的字节码文件
        //获取单个构造器,并根据构造器创建对象
        Constructor<?> constructor = aClass1.getConstructor();
        Object obj = constructor.newInstance();

        //获取所有公有方法，不包括被继承的方法
        Method method = aClass1.getDeclaredMethod(methodName);
        method.setAccessible(true);//暴力反射
        method.invoke(obj);

    }
}
