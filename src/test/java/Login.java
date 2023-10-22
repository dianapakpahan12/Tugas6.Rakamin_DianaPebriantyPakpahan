import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login {
    @Test
    public void open_browser(){
        WebDriver driver;
        String baseUrl = "https://kasirdemo.belajarqa.com/"; //set base url

        WebDriverManager.chromedriver().setup();

        //apply chrome driver set up
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String title = driver.getTitle();
        System.out.println(title);

        driver.close();
     }
}
