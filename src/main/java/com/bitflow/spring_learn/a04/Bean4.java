package com.bitflow.spring_learn.a04;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Bean1 class
 *
 * @author liyongqing
 * @date 2023/8/21
 */

/**
 * java.home=
 * java.version=
 */
@ConfigurationProperties(prefix = "java")
public class Bean4 {

    private String home;

    @Override
    public String toString() {
        return "Bean4{" +
                "home='" + home + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    private String version;


}
