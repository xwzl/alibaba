package cloud.alibaba.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xuweizhi
 * @since 2019/06/04 10:06
 */
@FeignClient(name = "order")
public interface OrderClient {

    @GetMapping("/order/create")
    String create(@RequestParam("orderId") String orderId, @RequestParam("quantity") String quantity);

}
