package com.h2s.demo.serviceone;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="service-two", url="localhost:8100")
public interface AddStringServiceProxy {

    @GetMapping("/add-string/{string}")
    public StringEntity addString(@PathVariable String string);
}
