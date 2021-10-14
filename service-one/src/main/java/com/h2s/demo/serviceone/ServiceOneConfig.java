/*
 * @created 14/10/2021 - 1:12 PM
 * @author vanha
 */

package com.h2s.demo.serviceone;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "service-one")
public class ServiceOneConfig {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ServiceOneConfig{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
