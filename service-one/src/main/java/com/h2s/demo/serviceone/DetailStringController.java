package com.h2s.demo.serviceone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
public class DetailStringController {

    @Autowired
    private AddStringServiceProxy addStringServiceProxy;

    @Autowired
    private Environment environment;

    @GetMapping("/add-string/{sample}")
    public StringEntity addString(@PathVariable String sample){
        StringEntity result = addStringServiceProxy.addString(sample);
        result.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return result;
    }
}
