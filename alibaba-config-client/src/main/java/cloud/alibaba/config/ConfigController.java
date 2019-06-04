package cloud.alibaba.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuweizhi
 * @since 2019/06/04 13:02
 */
@RestController
@RefreshScope
@RequestMapping("/config")
public class ConfigController {

    @Value("${datas}")
    private String test;

    @GetMapping("/test")
    public String test(){
        return  test;
    }

}
