package cloud.alibaba.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuweizhi
 * @since 2019/06/03 17:39
 */
@RestController
@RequestMapping
public class HttpController {

    @GetMapping("/test")
    public String test(String name) {
        return "test" + name;
    }
}
