package com.guighost.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author GuiGhost
 * @date 2021/03/25
 * @className LazyMan()
 * 描述：懒汉式单例模式\
 * 道高一尺，魔高一丈
 */
public class LazyMan {

    private static boolean key = false;

    private LazyMan(){
        /**
         * 解决反射破坏的单例
         * 但是两个对象都使用反射创建呢？此解决方案又会失效
         */
        synchronized (LazyMan.class){
            if (key==false){
                key = true;
            }else {
                throw new RuntimeException("不要视图破坏反射异常");
            }
        }
        System.out.println(Thread.currentThread().getName() + "OK");
    }
    private volatile static LazyMan lazyMan;

    //双重检测锁模式的懒汉式单例：——>DCL懒汉式
    public static LazyMan getInstance(){
        if (lazyMan==null){
            synchronized (LazyMan.class){
                if (lazyMan==null){
                    lazyMan = new LazyMan();//不是一个原子性操作
                    /**
                     * 1. 分配内存空间
                     * 2. 执行构造方法，初始化对象
                     * 3. 把这个对象指向这个空间
                     *
                     * 执行顺序：123
                     * 132：对象A
                     *     对象B：此是lazyMan还没有完成构造
                     * */
                }
            }
        }
        return lazyMan;
    }

    //单线程下单例ok
    

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
//        //多线程并发
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                LazyMan.getInstance();
//            }).start();
//        }

        //反射：破坏该单例
//        LazyMan instance = LazyMan.getInstance();

        Field key = LazyMan.class.getDeclaredField("key");
        key.setAccessible(true);

        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);//无视私有构造器
        LazyMan lazyMan = declaredConstructor.newInstance();
        key.set(lazyMan,false);
        LazyMan instance = declaredConstructor.newInstance();

        System.out.println(instance);
        System.out.println(lazyMan);
    }
}
