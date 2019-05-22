package cn.boommanpro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

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
            ServerProperties serverProperties = context.getBean(ServerProperties.class);
            int port = Optional.ofNullable(serverProperties.getPort()).orElse(8080);
            String contextPath = Optional.ofNullable(serverProperties.getServlet().getContextPath()).orElse("");
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
