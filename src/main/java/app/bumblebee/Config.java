package app.bumblebee;

import lombok.Getter;

import java.util.Properties;

@Getter
public class Config {

    private final String url;
    private final String username;
    private final String password;
    private final String browser;
    private final String isRemoteWebDriver;
    private final Properties properties;

    public Config(Properties properties) {
        this.properties = properties;
        this.url = properties.getProperty("test.url");
        this.username = properties.getProperty("test.username");
        this.password = properties.getProperty("test.password");
        this.browser = properties.getProperty("selenium.browser.name");
        this.isRemoteWebDriver = properties.getProperty("remote.driver");
    }
}