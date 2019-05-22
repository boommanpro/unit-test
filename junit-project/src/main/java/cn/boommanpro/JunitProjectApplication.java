package cn.boommanpro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author BoomManPro
 * @mail boommanpro@gmail.com
 */
@Slf4j
@SpringBootApplication
public class JunitProjectApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplication(JunitProjectApplication.class).run();
        try {
            String host = InetAddress.getLocalHost().getHostAddress();
            TomcatServletWebServerFactory tomcatServletWebServerFactory = (TomcatServletWebServerFactory) context.getBean("tomcatServletWebServerFactory");
            int port = tomcatServletWebServerFactory.getPort();
            String contextPath = tomcatServletWebServerFactory.getContextPath();
            log.info("<------------------------------------------ http://{}:{}{}/ ------------------------------------------>", host, port, contextPath);
        } catch (UnknownHostException e) {
            log.error("项目启动异常", e);
        }
        log.info("{}系统启动成功", JunitProjectApplication.class.getSimpleName());
    }


    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        log.info("ExitCodeGenerator Bean 创建");
        return () -> {
            log.error("执行退出码(88)生成...");
            return 88;
        };
    }
}
