package com.h2s.demo.serviceone;

import com.h2s.demo.serviceone.repository.Employee;
import com.h2s.demo.serviceone.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

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
}
