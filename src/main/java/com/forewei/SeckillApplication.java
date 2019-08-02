package com.forewei;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * 项目启动入口
 *
 * @Author forewei
 * @date 2019-5-21 17:27
 */
@SpringBootApplication
@ComponentScan("com.forewei")
public class SeckillApplication {
    private final static Logger LOGGER = LoggerFactory.getLogger(SeckillApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class, args);
        LOGGER.info("Seckill started");
    }

}
