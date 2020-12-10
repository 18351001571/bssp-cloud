package com.cloud.bssp.admin.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RedisTest
 * @date: 2020/12/4
 * @author weirx
 * @version 3.0
 */
@Component
@RestController
@RequestMapping("/admin")
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/redis/set")
    public  void set() {
        User user = new User();
        user.setName("Tom");
        user.setAge("33");
        //抛异常（DefaultSerializer requires a Serializable payload but received an object of type [com.cloud.bssp.admin.redis.RedisTest$User]）
        //默认情况下RedisTemplate模板只能支持字符串，我们自定义一个RedisTemplate，设置序列化器，这样我们可以很方便的操作实例对象。
        redisTemplate.opsForValue().set("user",user);
        User user1 = (User) redisTemplate.opsForValue().get("user");
    }

    static class User{

        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
