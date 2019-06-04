package cloud.alibaba.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * nacos 注册中心
 *
 * @author xuweizhi
 * @since 2019-6-3
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("cloud.alibaba.order.client")
@ComponentScan(basePackages = "cloud.alibaba")
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
