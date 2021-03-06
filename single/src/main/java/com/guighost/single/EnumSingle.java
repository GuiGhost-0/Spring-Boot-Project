package com.guighost.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author GuiGhost
 * @date 2021/03/25
 * @className EnumSingle()
 * 描述：
 */
//enum本身也是一个Class类
public enum EnumSingle {
    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }


}

class Test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingle instance1 = EnumSingle.INSTANCE;
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        EnumSingle instance2 = declaredConstructor.newInstance();

//        java.lang.NoSuchMethodException: com.guighost.single.EnumSingle.<init>()
        //没有空参构造器
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
