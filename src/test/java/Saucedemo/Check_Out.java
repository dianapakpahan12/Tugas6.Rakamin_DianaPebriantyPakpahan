package Saucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check_Out {
    @Test
    public void success_Checkout(){
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
        //Click Button Add To Cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //Click Shipping Cart
        driver.findElement(By.id("shopping_cart_container")).click();
        String Your_Cart = driver.findElement(By.xpath("//*[@id=\'header_container\']/div[2]/span")).getText();
        Assert.assertEquals(Your_Cart,"Your Cart");
        //Click Continue Shopping
        driver.findElement(By.id("checkout")).click();
        //Input First Name
        driver.findElement(By.id("first-name")).sendKeys("Rakamin");
        //Input Last Name
        driver.findElement(By.id("last-name")).sendKeys("Tugas");
        //Input Zip/Postal Code
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        //Click Button Continue
        driver.findElement(By.id("continue")).click();
        String Overview = driver.findElement(By.xpath("//*[@id=\'header_container\']/div[2]/span")).getText();
        Assert.assertEquals(Overview,"Checkout: Overview");
        String Payment_Information = driver.findElement(By.xpath("//*[@id=\'checkout_summary_container\']/div/div[2]/div[1]")).getText();
        Assert.assertEquals(Payment_Information, "Payment Information");
        String Shipping_Information = driver.findElement(By.xpath("//*[@id=\'checkout_summary_container\']/div/div[2]/div[3]")).getText();
        Assert.assertEquals(Shipping_Information, "Shipping Information");
        //Click Finish
        driver.findElement(By.id("finish")).click();
        String Thank_You = driver.findElement(By.xpath("//*[@id=\'checkout_complete_container\']/h2")).getText();
        Assert.assertEquals(Thank_You,"Thank you for your order!");

        //close browser
        driver.close();


    }
}
