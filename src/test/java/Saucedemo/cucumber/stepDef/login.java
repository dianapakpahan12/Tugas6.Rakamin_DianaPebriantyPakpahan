package Saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("Halaman Login Saucedemo")
    public void halaman_login_saucedemo(){
        driver = new ChromeDriver();
        driver.get(baseUrl);

        //assertion
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");

    }

    @When("input Username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("input Password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click Button Login")
    public void clickButtonLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User in on Dashboard page")
    public void userInOnDashboardPage() {
        String Product = driver.findElement(By.xpath("//*[@id=\'header_container\']/div[2]/span")).getText();
        Assert.assertEquals(Product,"Products");
    }

    @And("input Invalid Password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("standard_user");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String EpicSadFace = driver.findElement(By.xpath("//*[@id=\'login_button_container\']/div/form/div[3]")).getText();
        Assert.assertEquals(EpicSadFace,"Epic sadface: Username and password do not match any user in this service");
    }
}
