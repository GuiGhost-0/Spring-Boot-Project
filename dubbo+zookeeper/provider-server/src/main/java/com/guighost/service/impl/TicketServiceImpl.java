package com.guighost.service.impl;

import com.guighost.service.TicketService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author GuiGhost
 * @date 2021/04/02
 * @className TicketServiceImpl()
 * 描述：
 */

//zookeeper：服务注册与发现
@DubboService   //可以被扫描到，在项目启动就自动注册到注册中心
@Service    //这个注解是Spring的：是将这个了注入到Spring容器
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "《票是怎样得到的》";
    }
}
