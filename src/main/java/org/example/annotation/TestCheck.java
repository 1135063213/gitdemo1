package org.example.annotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCheck {
    public static void main(String[] args) throws IOException {
        Calculator c=new Calculator();
        Class cls=c.getClass(); //获取计算器对象字节码文件
        //获取所有public方法
        Method[] methods = cls.getMethods();

        int number=0; //出现异常的次数
        BufferedWriter bw=new BufferedWriter(new FileWriter("bug.txt"));
        //遍历public方法数组
        for(Method method:methods){
            //判断方法上是否定义了Check注解
            if(method.isAnnotationPresent(Check.class)){
                //是，需要检验方法是否有异常
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    number++;
                    bw.write(method.getName()+"方法出异常了");
                    bw.newLine();
                    bw.write("异常的名称："+e.getCause().getClass().getName());
                    bw.newLine();
                    bw.write("异常的原因："+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("---------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次测试一共出现"+number+"次异常");
        bw.flush();
        bw.close();
    }
}


/**
 * 1.大多数情况下我们使用注解，而非自定义注解
 * 2.注解给谁用：1）编译器 2）解析程序
 * 3.注解不是程序的一部分，像是标签
 */
