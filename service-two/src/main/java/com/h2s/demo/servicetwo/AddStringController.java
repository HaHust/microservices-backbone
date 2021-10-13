package com.h2s.demo.servicetwo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddStringController {

    @GetMapping("add-string/{string}")
    public StringEntity addString(@PathVariable String string) {
        StringEntity stringEntity = new StringEntity();
        String newResult = string+"added";
        stringEntity.setMsg(newResult);
        return stringEntity;
    }
}
