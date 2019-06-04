package cloud.alibaba.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuweizhi
 * @since 2019/06/04 10:09
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/create")
    public String create(String orderId, String quantity) {
        return "OrderId : " + orderId + " ,Quantity : " + quantity;
    }

}
