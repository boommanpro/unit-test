package cn.boommanpro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author BoomManPro
 * @mail boommanpro@gmail.com
 */
@Slf4j
@SpringBootApplication
public class JunitProjectApplication {
    public static void main(String[] args) {
        new SpringApplication(JunitProjectApplication.class).run(args);
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
