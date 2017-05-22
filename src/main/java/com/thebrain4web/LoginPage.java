package com.thebrain4web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by nikarog on 22.05.2017.
 */
public class LoginPage {
    private WebDriver driver;

    private By emailAddressField = By.name("email");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath(".//*[@id='login']/input[@class='btn btn-primary rounded' and @type='submit']");
    private By loginLogo = By.xpath(".//*[@id='login']/h1");
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void fillEmailField(String email){
        driver.findElement(emailAddressField).clear();
        driver.findElement(emailAddressField).sendKeys(email);
    }

    public void fillPasswordField(String password){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOLoginButton(){
        driver.findElement(loginButton).click();
    }

    public boolean isLoginPage(){
        return driver.findElement(loginLogo).isDisplayed();
    }
}
