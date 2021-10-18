package com.h2s.demo.serviceone;

import com.h2s.demo.serviceone.repository.Employee;
import com.h2s.demo.serviceone.repository.EmployeeRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class DetailStringController {

    @Autowired
    private AddStringServiceProxy addStringServiceProxy;

    @Autowired
    private Environment environment;

    @Autowired
    private ServiceOneConfig serviceOneConfig;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/add-string/{sample}")
    public StringEntity addString(@PathVariable String sample){
        StringEntity result = addStringServiceProxy.addString(sample);
        result.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return result;
    }

//    This is a entrypoint which is an example for getting config infor
    @GetMapping("/properties")
    public List<Employee> getProperty(){
        return employeeRepository.findAll();
    }


    // Working with Resilience4j
    @GetMapping("/sample-url")
//    @Retry(name="service-two", fallbackMethod = "serviceTwoFallBack")
    @CircuitBreaker(name = "default", fallbackMethod = "serviceTwoFallBack")
    public String testResilency4j(){
        ResponseEntity<String> stringResponseEntity = new RestTemplate().getForEntity("http://localhost:9000/aasdf", String.class);
        return stringResponseEntity.getBody();
    }

    public String serviceTwoFallBack(Exception ex){
        return "can't call api in service two"+ex;
    }
}
