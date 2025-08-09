package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserHeadlessTest {
    private WebDriver driver;
    private final String URL = "https://practicetestautomation.com/practice-test-login/";

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        System.out.println("Iniciando prueba en navegador: " + browser);
        driver = initializeDriver(browser);
    }

    private WebDriver initializeDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                return new ChromeDriver(chromeOptions);
                
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                return new FirefoxDriver(firefoxOptions);
                
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
    }

    @Test
    public void testLoginPageTitle() {
        driver.get(URL);
        
        String title = driver.getTitle();
        System.out.println("Título obtenido: " + title);
        
        Assert.assertEquals(title, "Test login", 
            "El título de la página no es el esperado");
        
        System.out.println("Prueba exitosa - Título verificado correctamente");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
