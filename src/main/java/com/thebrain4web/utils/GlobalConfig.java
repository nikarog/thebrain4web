package com.thebrain4web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by nikarog on 22.05.2017.
 */
public class GlobalConfig {

    private static String email = System.getenv("LOGIN_VALUE");
    private static String password = System.getenv("LOGIN_PASSWORD");
    private static String baseURL = System.getenv("BASE_URL");

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public static String getBaseURL() {
        return baseURL;
    }


    public static ChromeOptions setProp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("test-type");
        capabilities.setCapability("chrome.binary","src/main/resources/drivers/chromedriver/chromedriver.exe");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return options;
    }
}
