package com.thebrain4web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by nikarog on 22.05.2017.
 */
public class DashboardPage {
    private WebDriver driver;

    private By gigsButton = By.cssSelector("body > div > aside > section > ul > li:nth-child(2) > a");

    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }

    public void clickOnTheGigsButton(){
        driver.findElement(gigsButton).click();
    }
}
