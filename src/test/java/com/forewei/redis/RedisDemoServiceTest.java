package com.forewei.redis;

import com.forewei.component.RedisComponent;
import com.forewei.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Date: Create By on 2019/8/2
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(RedisDemoServiceTest.class);

    @Autowired
    private RedisComponent redisComponent;

    @Test
    public void test() {
        redisComponent.set("forewei", new User().setId(123l).setNickname("forewei").setRegisterDate(new Date()).setLastLoginDate(new Date()));
        LOG.info("缓存设置成功！");
    }
}
