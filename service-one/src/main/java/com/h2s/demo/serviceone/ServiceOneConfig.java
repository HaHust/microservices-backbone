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

    private String usernameDB;

    private String passwordDB;

    private String url;

    private String driverDB;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUsernameDB() {
        return usernameDB;
    }

    public void setUsernameDB(String usernameDB) {
        this.usernameDB = usernameDB;
    }

    public String getPasswordDB() {
        return passwordDB;
    }

    public void setPasswordDB(String passwordDB) {
        this.passwordDB = passwordDB;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverDB() {
        return driverDB;
    }

    public void setDriverDB(String driverDB) {
        this.driverDB = driverDB;
    }

    @Override
    public String toString() {
        return "ServiceOneConfig{" +
                "msg='" + msg + '\'' +
                ", usernameDB='" + usernameDB + '\'' +
                ", passwordDB='" + passwordDB + '\'' +
                ", url='" + url + '\'' +
                ", driverDB='" + driverDB + '\'' +
                '}';
    }
}
