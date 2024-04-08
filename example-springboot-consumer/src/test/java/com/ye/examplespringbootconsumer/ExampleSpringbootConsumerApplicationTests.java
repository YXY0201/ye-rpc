package com.ye.examplespringbootconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 单元测试
 */

@SpringBootTest
class ExampleSpringbootConsumerApplicationTests {

    @Resource
    private ExampleServiceImpl exampleService;

    @Test
    void test1(){exampleService.test();}

}
