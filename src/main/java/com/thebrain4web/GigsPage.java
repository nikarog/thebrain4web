package com.thebrain4web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by nikarog on 22.05.2017.
 */
public class GigsPage {

    private WebDriver driver;
    private WebElement documentId;
    private By viewButton = By.xpath(".//span[@class='label status label-danger']/../../td[@class='actions']/a[@title='View']");
    private By deleteButton = By.xpath(".//button[@type='button' and @class='btn btn-danger js-delete-confirm']");
    private By documentIdInGrid = By.xpath(".//span[@class='label status label-danger']/../../td[@class='actions']/a[@title='View']/../../../../tbody/tr[2]/td[1]");

    public GigsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void viewExpiredDocument() {
        driver.findElement(viewButton).click();
    }

    public boolean isDocumentDeleted() {
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        documentId = driver.findElement(documentIdInGrid);
        return documentId.isEnabled();
    }

    public void clickOnDeleteButton(){
        driver.findElement(deleteButton).click();
        driver.switchTo().alert().accept();
    }
}
