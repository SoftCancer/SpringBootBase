package com.ygx.bootbase.common.listener.event;

import com.ygx.bootbase.entity.User;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2021/3/19 23:11
 * @Version: 1.0
 */
@Data
public class MyEvent extends ApplicationEvent {

    private User user;

    public MyEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
