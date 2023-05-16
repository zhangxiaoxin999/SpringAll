package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.BlogProperties;
import com.springboot.bean.ConfigBean;
import com.springboot.bean.TestConfigBean;

/**
 * 以上三个类中使用了不同的调用properties文件参数的方法
 * 1.BlogProperties中使用@Component;@Value("${mrbird.blog.name}")/@Value("4 m")前者引用后者直接赋值
 * 2.ConfigBean中使用@ConfigurationProperties(prefix = "mrbird.blog")
 * 3.TestConfigBean中使用  @Configuration
 *                        @ConfigurationProperties(prefix = "test")
 *                        @PropertySource("classpath:test.properties")
 *                        @Component
 */

@RestController
public class IndexController {
    @Autowired
    private BlogProperties blogProperties;
    @Autowired
    private ConfigBean configBean;
    @Autowired
    private TestConfigBean testConfigBean;

    @RequestMapping("/")
    String index() {
        //blogProperties.set;
        configBean.setName("configBean");
        return  blogProperties.getHeight()+ configBean.getName() + "++" + configBean.getTitle() + configBean.getWholeTitle() + testConfigBean.getName() + "，" + testConfigBean.getAge();
    }
}
