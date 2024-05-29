package programmerzamannow.webmvc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloServiceImplTest {
    @Autowired
    private HelloService helloService;

    @Test
    void testHello(){
        Assertions.assertEquals("Hello Guest", helloService.hello(null));
        Assertions.assertEquals("Hello Ahmad", helloService.hello("Ahmad"));
    }
}