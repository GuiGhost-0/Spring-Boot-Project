package com.guighost.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author GuiGhost
 * @date 2021/04/02
 * @interfaceName UserServer()
 * 描述：消费者服务类
 */
@Service
public class UserService {
    //想拿到provider-server提供的票，得去注册中心拿到服务
    @DubboReference //引用：1. Pom坐标    2. 也可以定义路径相同的接口名
    TicketService ticketService;

    public void buyTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("在注册中心拿到=>" + ticket);
    }
}
