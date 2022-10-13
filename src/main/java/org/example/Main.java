package org.example;

/**
 * 创建线程方式1：继承Thread类
 * 1.定义一个MyThread类继承Thread
 * 2.MyThread类中重写run方法
 * 3.创建MyThread类对象
 * 4.启动线程
 */

import org.example.Animal.AnimalOperator;
import org.example.Animal.Cat;
import org.example.Animal.Dog;
import org.example.annotation.MyAnno;
import org.example.lambdademo.*;
import org.example.product.Box;
import org.example.product.Customer;
import org.example.product.Producer;
import org.example.reflex.Teacher;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 创建线程方式2：实现Runnable接口
 * 1.定义一个类MyRunnable实现Runnable接口
 * 2.MyRunnable类中重写run方法
 * 3.创建MyRunnable类对象
 * 4.创建Thread类对象，把MyRunnable对象作为构造方法的参数
 * 5.启动线程
 */

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, IOException {

        /**
         * 无参构造方法
         * MyThread thread1=new MyThread();
         * MyThread thread2=new MyThread();
         * thread1.setName("高铁");
         * thread2.setName("飞机");
         * thread1.start();
         * thread2.start();
         */

        /**
         * 有参构造
         * MyThread thread1=new MyThread("高铁");
         * MyThread thread2=new MyThread("飞机");
         * thread1.start();
         * thread2.start();
         */

        //static Thread currentThread() 返回当前正在执行的线程的引用
//        System.out.println(Thread.currentThread().getName());
//============================================================================
        /**
         * 线程调度模型有两种：
         * 1.分时调动模型：所有线程轮流使用CPU的使用权，平均分配每个线程占用CPU的时间片
         * 2.抢占式调用模型：优先让优先级高的线程使用CPU，如果线程的优先级相同，那么会随机选择一个，优先级高的线程获取的时间片相对多一些
         * Java使用的是抢占式调用模型
         *
         * Thread中设置和获取线程优先级的方法
         * public final int getPriority()
         * public final void setPriority(int newPriority)
         */

        /**
         * MyThread tp1=new MyThread("高铁");
         * MyThread tp2=new MyThread("飞机");
         * MyThread tp3=new MyThread("汽车");
         *
         *
         * System.out.println(tp1.getPriority());//默认是5，最高是10，最低是1
         * System.out.println(tp2.getPriority());
         * System.out.println(tp3.getPriority());
         *
         * tp1.setPriority(5);
         * tp2.setPriority(10);
         * tp3.setPriority(1);
         *
         * tp1.start();
         * tp2.start();
         * tp3.start();
         */
//============================================================================
        /**
         * 线程控制
         * static void sleep(long millis) 使当前正在执行的线程停留的毫秒数
         * void join() 等待这个线程死亡
         * void setDaemon(boolean on) 将此线程标记为守护线程，当运行的线程都为守护线程时，JVM将退出
         */

         /*ThreadSleep t1=new ThreadSleep("曹操");
         ThreadSleep t2=new ThreadSleep("刘备");
         ThreadSleep t3=new ThreadSleep("孙权");

         t1.start();
         t2.start();
         t3.start();*/



         /*MyThread t1=new MyThread("康熙");
         MyThread t2=new MyThread("四阿哥");
         MyThread t3=new MyThread("八阿哥");

         t1.start();
         try {
             t1.join();//康熙线程死亡后，其他线程开始执行
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
         t2.start();
         t3.start();*/



         /*MyThread t1=new MyThread("关羽");
         MyThread t2=new MyThread("张飞");

         //设置主线程为刘备
         Thread.currentThread().setName("刘备");

         //设置守护线程(主线程死亡后很快退出)
         t1.setDaemon(true);
         t2.setDaemon(true);

         t1.start();
         t2.start();

         for(int i=0;i<10;i++){
             System.out.println(Thread.currentThread().getName()+":"+i);
         }*/
//============================================================================
        //实现Runnable接口方式创建线程

        /*MyRunnable mr=new MyRunnable();

        Thread t1=new Thread(mr,"高铁");
        Thread t2=new Thread(mr,"动车");

        t1.start();
        t2.start();*/
//============================================================================
        /**
         * 数据安全问题:1.多次输出相同 2.输出负数
         * 出现情况：1.多线程环境 2.共享数据 3.多条语句操作共享数据
         * 解决方法：把多条语句操作共享数据的代码给锁起来，让任意时刻只能有一个线程执行即可（同步代码块加锁）
         */
        /*SellTickets st=new SellTickets();
        Thread t1=new Thread(st,"窗口1");
        Thread t2=new Thread(st,"窗口2");
        Thread t3=new Thread(st,"窗口3");

        t1.start();
        t2.start();
        t3.start();*/

        /*//线程安全集合类
        StringBuffer sb1=new StringBuffer();
        StringBuilder sb2=new StringBuilder();

        Vector<String> vec1=new Vector<>();
        ArrayList<String> vec2=new ArrayList<>();

        Hashtable<String,String> hm1=new Hashtable<>();
        HashMap<String,String> hm2=new HashMap<>();

        //实际中StringBuffer在线程安全中使用，但很少使用Vector和Hashtable，被代替如下
        List<String> list= Collections.synchronizedList(new ArrayList<>());*/


        //利用Lock锁同步
        /*SellTicketsSecond st=new SellTicketsSecond();
        Thread t1=new Thread(st,"窗口1");
        Thread t2=new Thread(st,"窗口2");
        Thread t3=new Thread(st,"窗口3");

        t1.start();
        t2.start();
        t3.start();*/
//============================================================================
        /**
         * Object类中线程等待和唤醒的方法
         * void wait() 线程等待，直到另一个对象调用该线程对象的notify()方法或者notifyAll()方法
         * void notify() 唤醒正在等待对象监视器的单个线程
         * void notifyAll() 唤醒正在等待对象监视器的所有线程
         */

        /*//创建一个奶箱对象,这是共享数据区域
        Box box = new Box();

        //创建生产者对象，将奶箱对象作为构造方法参数传递，因为这个类中要调用存储牛奶的操作
        Producer producer=new Producer(box);
        //创建生消费者对象，将奶箱对象作为构造方法参数传递，因为这个类中要调用取牛奶的操作
        Customer customer=new Customer(box);

        Thread t1=new Thread(producer);
        Thread t2=new Thread(customer);

        t1.start();
        t2.start();*/
//============================================================================
        /*AnimalOperator ao=new AnimalOperator();
        Dog dog=new Dog();
        ao.useAnimal(dog);*/
//============================================================================
/*        Eatable e=new EatableImpl();
        useEatable(e);

        useEatable(new Eatable(){
            @Override
            public void eat(){
                System.out.println("一天一苹果，医生远离我");
            }
        });

        useEatable( ()->{System.out.println("一天一苹果，医生远离我");} );


        useConverter( (String s) -> {return Integer.parseInt(s);} );
        useConverter( s -> Integer.parseInt(s) );
        useConverter( Integer::parseInt );


        usePrinter( s->System.out.println(s.toUpperCase()) );
        PrintString ps=new PrintString();
        usePrinter(ps::printUpper);


        useMyString( (s,x,y) -> s.substring(x,y));
        useMyString(String::substring);

        useStudentBuilder((s,i)->new Student(s,i));
        useStudentBuilder(Student::new);*/
//============================================================================
        /*ArrayList arrayList=new ArrayList<>();
        arrayList.add("ddd");
        arrayList.add("aa");
        arrayList.add("c");
        arrayList.add("bbbb");
        System.out.println(arrayList);

        Collections.sort(arrayList);
        System.out.println(arrayList);

        Collections.sort(arrayList,getComparator());
        System.out.println(arrayList);*/
//============================================================================
        /*ClassLoader c=ClassLoader.getSystemClassLoader();
        System.out.println(c);

        ClassLoader c2=c.getParent();
        System.out.println(c2);

        ClassLoader c3=c2.getParent();
        System.out.println(c3);*/


        /*//1.使用类的class属性来获取该类对应的Class对象
        Class<Teacher> c1=Teacher.class;
        System.out.println(c1);

        Class<Teacher> c2=Teacher.class;
        System.out.println(c1==c2);
        System.out.println("--------");

        //2.调用对象的getClass()方法，获取对象所属类对应的Class对象
        Teacher t1=new Teacher();
        Class<? extends Teacher> c3 = t1.getClass();
        System.out.println(c1==c3);
        System.out.println("--------");

        //3.使用Class类静态方法forName(String className)
        Class<?> c4 = Class.forName("org.example.reflex.Teacher");
        System.out.println(c1==c4);*/


/*        Class<?> c = Class.forName("org.example.reflex.Teacher");
        //Constructor<?>[] getConstructors()
        //返回一个包含Constructor对象的数组 Constructor对象反映了由该Class对象表示的类的所有公共构造函数。
        //Constructor<?>[] constructors = c.getConstructors();
        //Constructor<?>[] getDeclaredConstructors()
        //返回一个反映 Constructor对象表示的类声明的所有构造函数的 Constructor对象的数组 类 。
        Constructor<?>[] declaredConstructors = c.getDeclaredConstructors();
        for(Constructor con:declaredConstructors){
            System.out.println(con);
        }

        //获取单个构造器,并根据构造器创建对象
        Constructor<?> constructor = c.getConstructor(String.class,int.class,String.class);
        Object obj = constructor.newInstance("刘亦菲",18,"武汉");
        System.out.println(obj);

        //暴力反射，通过私有构造器创建对象
        Constructor<?> decCon = c.getDeclaredConstructor(String.class);
        decCon.setAccessible(true);

        Object obj2 = decCon.newInstance("林青霞");
        System.out.println(obj2);*/


        /*Class<?> c = Class.forName("org.example.reflex.Teacher");
//        Field[] fields=c.getFields();//获取所有公有变量
        Field[] fields = c.getDeclaredFields();//获取所有变量
        for(Field field:fields){
            System.out.println(field);
        }

        //通过反射设置成员变量值，并赋值给无参构造对象
        Field addressField = c.getField("address");
        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();
        addressField.set(obj,"上海");
        System.out.println(obj);*/


        /*Class<?> c = Class.forName("org.example.reflex.Teacher");
//        Method[] methods = c.getMethods();//获取所有公有方法，包括被继承的方法
        Method[] methods = c.getDeclaredMethods();//获取所有公有方法，不包括被继承的方法
        for(Method method:methods){
            System.out.println(method);
        }

        Method m1 = c.getMethod("method1");
        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();
        m1.invoke(obj);*/

        //反射练习1：在一个ArrayList<Integer>对象中添加String变量
        ArrayList<Integer> array=new ArrayList<>();
        Class<? extends ArrayList> aClass = array.getClass();
        Method m = aClass.getMethod("add", Object.class);
        m.invoke(array,"hello");
        m.invoke(array,"world");
        m.invoke(array,"Java");
        System.out.println(array);


        //反射练习2：通过配置文件运行类中方法,如果要运行不同类的方法只需要修改我们的配置文件即可
        /**
         * class.txt
         * className=xxx
         * methodName=xxx
         * 例如：
         * className=org.example.reflex.Teacher
         * methodName=method1
         */
        //加载class.txt
        Properties prop = new Properties();
        FileReader fr=new FileReader(System.getProperty("user.dir")+"\\class.txt");
        prop.load(fr);
        fr.close();

        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        Class<?> aClass1 = Class.forName(className);
        Constructor<?> constructor = aClass1.getConstructor();
        Object obj = constructor.newInstance();

//        Method method = aClass1.getMethod(methodName);
        Method method = aClass1.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(obj);



    }

/*    private static void useEatable(Eatable e){
        e.eat();
    }
    private static void useConverter(Converter c){
        int number=c.converter("666");
        System.out.println(number);
    }
    private static void usePrinter(Printer p){
        p.printUpperCase("Helloworld");
    }
    private static void useMyString(MyString ms){
        String s=ms.mySubString("Helloworld",2,5);
        System.out.println(s);
    }
    private static void useStudentBuilder(StudentBuilder sb){
        Student s=sb.build("刘亦菲",18);
        System.out.println(s.getName()+","+s.getAge());
    }*/

    /*private static Comparator<String> getComparator(){
        *//*return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };*//*

        return (o1,o2)->o1.length()-o2.length();
    }*/

}