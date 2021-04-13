package com.guighost.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author GuiGhost
 * @date 2021/03/30
 * @className AsyncService()
 * 描述：异步业务类
 */
@Service
public class AsyncService {

    //告诉Spring这是一个异步的方法
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据正在处理...");
    }
}
