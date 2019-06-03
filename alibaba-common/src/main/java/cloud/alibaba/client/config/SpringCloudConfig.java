package cloud.alibaba.client.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuweizhi
 * @since 2019/06/03 17:51
 */
@Configuration
public class SpringCloudConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //@Bean
    //@LoadBalanced
    //public WebClient.Builder loadBalancedWebClientBuilder() {
    //    return WebClient.builder();
    //}

}
