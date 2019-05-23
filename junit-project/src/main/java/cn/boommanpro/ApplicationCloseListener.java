package cn.boommanpro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationCloseListener implements ApplicationListener<ContextClosedEvent> {

    @Autowired
    private ApplicationContext context;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        log.error("unit-test服务关闭");
    }
}
