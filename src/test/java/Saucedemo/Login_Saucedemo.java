package Saucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_Saucedemo {
    @Test
    public void success_login_case(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/"; //set base url

        WebDriverManager.chromedriver().setup();

        //apply chrome driver set up
        //membuka halaman login
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
        //input email
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click button login
        driver.findElement(By.id("login-button")).click();
        String Product = driver.findElement(By.xpath("//*[@id=\'header_container\']/div[2]/span")).getText();
        Assert.assertEquals(Product,"Products");

        //close browser
        driver.close();


    }

    @Test
    public void failed_login_case(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/"; //set base url

        WebDriverManager.chromedriver().setup();

        //apply chrome driver set up
        //membuka halaman login
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
        //input email
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input password
        driver.findElement(By.id("password")).sendKeys("standard_user");
        //click button login
        driver.findElement(By.id("login-button")).click();
        String EpicSadFace = driver.findElement(By.xpath("//*[@id=\'login_button_container\']/div/form/div[3]")).getText();
        Assert.assertEquals(EpicSadFace,"Epic sadface: Username and password do not match any user in this service");

        //close browser
        driver.close();

    }
}
