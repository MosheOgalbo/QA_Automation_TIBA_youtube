import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserDriver {
    public static  WebDriver chromeDriverBrowser(String goToBrowse){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.navigate().to(goToBrowse);
        return driver;
    }
    public static WebDriverWait waitDrivervElementToBeClickable(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return  wait;
    }
    public static WebDriverWait waitInvisibilityOfElementLocated (WebDriver driver, By by){
        WebDriverWait waitDriver = new WebDriverWait(driver,Duration.ofSeconds(20));
        waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(by));
        return waitDriver;
    }
    public static WebDriverWait waitVisibilityOfElementLocated (WebDriver driver, By by){
        WebDriverWait waitDriver = new WebDriverWait(driver,Duration.ofSeconds(20));
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(by));
        return waitDriver;
    }
}
