package cloud.alibaba.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuweizhi
 * @since 2019/06/03 17:40
 */
@RestController
@RequestMapping
public class ClientController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    /**
     * 可以看到，在定义RestTemplate的时候，增加了@LoadBalanced注解，而在真正调用服务接口的时候，原来host部分是通过手工拼接ip和端口的，直
     * 接采用服务名的时候来写请求路径即可。在真正调用的时候，Spring Cloud会将请求拦截下来，然后通过负载均衡器选出节点，并替换服务名部分为具
     * 体的ip和端口，从而实现基于服务名的负载均衡调用。
     */
    @Autowired
    private RestTemplate restTemplate;

    //@Autowired
    //private WebClient.Builder webClientBuilder;

    @GetMapping("/test")
    public String test() {
        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("server");
        String url = serviceInstance.getUri() + "/test?name=" + "didi";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "Invoke : " + url + ", return : " + result;
    }

    @GetMapping("/increase")
    public String increaseRestTemplate() {
        String forObject = restTemplate.getForObject("http://server/test?name=haha", String.class);
        return forObject;
    }

    //@GetMapping("/webflex")
    //public Mono<String> test() {
    //    Mono<String> result = webClientBuilder.build()
    //            .get()
    //            .uri("http://alibaba-nacos-discovery-server/hello?name=didi")
    //            .retrieve()
    //            .bodyToMono(String.class);
    //    return result;
    //}

}
