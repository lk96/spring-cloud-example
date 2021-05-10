package org.kevin;

import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@RestController
public class ConsumerReactiveController {

    @Resource
    private ReactiveDiscoveryClient reactiveDiscoveryClient;

    @Resource
    private WebClient.Builder webClientBuilder;

    @GetMapping("/all-services")
    public Flux<String> allServices() {
        return reactiveDiscoveryClient.getInstances("nacos-discovery-provider")
                .map(serviceInstance -> serviceInstance.getHost() + ":"
                        + serviceInstance.getPort());
    }

    @GetMapping("/service-call/{name}")
    public Mono<String> serviceCall(@PathVariable("name") String name) {
        return webClientBuilder.build().get()
                .uri("http://nacos-discovery-provider/say/" + name).retrieve()
                .bodyToMono(String.class);
    }
}
