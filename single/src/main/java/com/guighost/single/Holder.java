package com.guighost.single;

/**
 * @author GuiGhost
 * @date 2021/03/25
 * @className Holder()
 * 描述：静态内部类
 */
public class Holder {
    private Holder(){

    }

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    public static  class InnerClass{
        private static final Holder HOLDER = new Holder();
    }
}
