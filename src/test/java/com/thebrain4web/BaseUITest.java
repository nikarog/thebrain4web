package com.thebrain4web;

import com.thebrain4web.utils.GlobalConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by nikarog on 22.05.2017.
 */
public class BaseUITest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(GlobalConfig.setProp());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to(GlobalConfig.getBaseURL());
    }

    @AfterMethod
    public void close() {
        driver.close();
    }

    @Test
    public void verifyNavigateToLoginPage() {
        MainPage page = new MainPage(driver);
        page.clickOnLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPage());
    }

    @Test
    public void verifyLoginAsAdmin() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmailField(GlobalConfig.getEmail());
        loginPage.fillPasswordField(GlobalConfig.getPassword());
        loginPage.clickOLoginButton();
        Assert.assertEquals(driver.getTitle(), "Dashboard – clevergig");
    }

    @Test
    public void verifyNavigareToGigsPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmailField(GlobalConfig.getEmail());
        loginPage.fillPasswordField(GlobalConfig.getPassword());
        loginPage.clickOLoginButton();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickOnTheGigsButton();
        Assert.assertEquals(driver.getTitle(), "Gigs – clevergig");
    }

    @Test
    public void verifyDeletingExpiredDocument() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmailField(GlobalConfig.getEmail());
        loginPage.fillPasswordField(GlobalConfig.getPassword());
        loginPage.clickOLoginButton();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickOnTheGigsButton();
        GigsPage gigsPage = new GigsPage(driver);
        gigsPage.viewExpiredDocument();
        gigsPage.clickOnDeleteButton();
        Assert.assertTrue(gigsPage.isDocumentDeleted());
    }
}
