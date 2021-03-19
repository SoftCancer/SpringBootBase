package com.ygx.bootbase.common.listener;

import com.ygx.bootbase.common.listener.event.MyEvent;
import com.ygx.bootbase.entity.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Description: 自定义监听器，可以用于 通知别的微服务或者处理其他业务逻辑
 * @author: YaoGuangXun
 * @date: 2021/3/19 23:15
 * @Version: 1.0
 */
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        // 获取事件中的信息
        User user = myEvent.getUser();
        // 处理事件，实际项目中可以通知别的微服务或者处理其他逻辑等等
        System.out.println("用户名：" + user.getUserName());
        System.out.println("密码：" + user.getPassWord());
    }
}
