package dev.habibzad.tests;

import dev.habibzad.pages.LoginPage;
import dev.habibzad.pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageTest{

    private final Logger logger = LoggerFactory.getLogger(LoginPageTest.class);

    private static final String VALID_USERNAME = "standard_user";
    private static final String VALID_PASSWORD = "secret_sauce";
    private static final String INVALID_PASSWORD = "spoiled_sauce";
    private static final String BASE_URL = "https://www.saucedemo.com/";
    private static final String INVENTORY_PAGE_URL = "https://www.saucedemo.com/inventory.html";

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup(){
        logger.debug("Before method executed");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver);
    }


    @Test()
    public void loginPageTestWithValidCredentials() {
        logger.debug("Login method test with valid credentials executed");
        loginPage.enterUsername(VALID_USERNAME);
        loginPage.enterPassword(VALID_PASSWORD);
        loginPage.login();
        assertThat(driver.getCurrentUrl()).isEqualTo(INVENTORY_PAGE_URL);
    }

    @Test
    public void loginPageTestWithInValidCredentials() {
        logger.debug("Login method test with invalid credentials executed");
        loginPage.enterUsername(VALID_USERNAME);
        loginPage.enterPassword(INVALID_PASSWORD);
        loginPage.login();
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        assertThat(errorMessage.getText()).isEqualTo("Epic sadface: Username and password do not match any user in this service");
    }

    @AfterMethod
    public void tearDown(){
        logger.debug("Tear down method executed");
        if (Objects.nonNull(driver)){
            driver.quit();
        }
    }



}
