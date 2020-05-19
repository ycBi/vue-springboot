package com.byc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ftp")
public class ImageServerConfig {
    private String address;

    private Integer port;

    private String username;

    private String password;

    private String basePath;

    private String imageBaseUrl;

    public String getAddress() {
        return address;
    }

    public Integer getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getbasePath() {
        return basePath;
    }

    public String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setbasePath(String basePath) {
        this.basePath = basePath;
    }

    public void setImageBaseUrl(String imageBaseUrl) {
        this.imageBaseUrl = imageBaseUrl;
    }
    public ImageServerConfig(){

    }
}
