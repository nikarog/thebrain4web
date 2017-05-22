package com.thebrain4web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by nikarog on 22.05.2017.
 */
public class MainPage {

    private WebDriver driver;

    private By loginButton = By.cssSelector("body > div.wrapper > header > div > ul:nth-child(2) > li:nth-child(3) > a");


    public MainPage(WebDriver driver){
        this.driver=driver;

    }

    public void clickOnLoginButton(){
        driver.findElement(loginButton).click();
    }
}
