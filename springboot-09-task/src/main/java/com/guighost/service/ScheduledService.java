package com.guighost.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author GuiGhost
 * @date 2021/03/30
 * @className ScheduledService()
 * 描述：
 */
@Service
public class ScheduledService {


    //在一个特定的时间执行这个方法
    //@Scheduled(cron表达式)
    //秒 分 时 日 月 星期

    /**
     * 50 58 21 * * ?   每天的21点58分50秒的时候执行
     *
     * 50 0/5 21,00 * * ?   每天的21点和00点，每隔5分钟执行一次
     *
     * 0 15 21 ? * 1-6  每个月的周一到周六的21点15分00秒执行
    */
    @Scheduled(cron = "0/2 * * * * ?")//这里是每隔两秒执行一次
    public void hello(){
        System.out.println("hello,你被执行了~" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

    }
}
