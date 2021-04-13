package com.guighost.single;

/**
 * @author GuiGhost
 * @date 2021/03/25
 * @className Hungry()
 * 描述：饿汉式单例
 */
public class Hungry {
    private Hungry(){

    }

    private final static Hungry HUNGRY = new Hungry();//final：唯一的

    public static Hungry getInstance(){
        return HUNGRY;
    }
}
