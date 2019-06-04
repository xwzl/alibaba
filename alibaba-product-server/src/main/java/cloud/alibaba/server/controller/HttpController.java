package cloud.alibaba.server.controller;

import cloud.alibaba.order.client.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author xuweizhi
 * @since 2019/06/03 17:39
 */
@RestController
@RequestMapping
public class HttpController {

    @Autowired
    private OrderClient orderClient;

    @GetMapping("/hello")
    public String hello(String name) {
        return "test" + name;
    }

    @GetMapping("/create")
    public String create() {
        return orderClient.create(UUID.randomUUID().toString(), "1");
    }

}
