package org.example.annotation;

import java.lang.annotation.*;

@Target(value= ElementType.METHOD) //只能作用于方法
@Retention(value= RetentionPolicy.RUNTIME) //描述注解保留的阶段
//RUNTIME当前被描述的注解，会保留到class字节码文件中，并被JVM读取到
//CLASS 当前被描述的注解，会保留到class字节码文件中，但不会被JVM读取到
//SOURCE 当前被描述的注解，既不会会保留到class字节码文件中，也不会被JVM读取到，这类注解仅在编译阶段有效，例如@Override
@Documented //javadoc生成文档后，在使用注解的地方保留注解
@Inherited //如果注解中时使用了该元注解，且一个类使用了该注解，该类的子类会自动继承该注解
public @interface MyAnno {
}
