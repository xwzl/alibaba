package cloud.alibaba.order.controller.server;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * name 为服务的名称
 * @author xuweizhi
 * @since 2019/06/04 9:42
 */
@FeignClient(name="server")
public interface ClientServer {

    @GetMapping("/hello")
    String hello(@RequestParam(name = "name") String name);

}
