import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class TestMain {

    WebDriver driver;
    String selectedVideo,findOfVideoURL="watch?v=ybXrrTX3LuI";
    String artistName;
    boolean testboolean;

    @BeforeTest
    public void setup() {
       // ExtentReports extent = new ExtentReports();
        driver= BrowserDriver.chromeDriverBrowser("https://www.youtube.com");
    }
    @Test
    public void step1() throws InterruptedException {
   //     sleep(1000);
        BrowserDriver.waitDrivervElementToBeClickable(driver, ElementsBrowser.bycssSelectorSearchFie());
        ElementsBrowser.searchField(driver).click();
    }
    @Test
    public void step2(){
        ElementsBrowser.searchField(driver).sendKeys("I Will Survive - Alien song" + Keys.ENTER);
        BrowserDriver.waitInvisibilityOfElementLocated(driver,ElementsBrowser.previewBar());

    }
    @Test
    /* Opens and closes the filter window because every girl closes this window
     (step3 add step 6)*/
    public void step3() throws InterruptedException {
        BrowserDriver.waitDrivervElementToBeClickable(driver, ElementsBrowser.byFILTERS());
        ElementsBrowser.elementFILTERS(driver).click();
        BrowserDriver.waitDrivervElementToBeClickable(driver, ElementsBrowser.byScreenOfFilters());
        sleep(10);
        ElementsBrowser.elementFILTERS(driver).click();
    }
    @Test
    public void step4()  {
        BrowserDriver.waitInvisibilityOfElementLocated(driver, ElementsBrowser.byScreenOfFilters());
        BrowserDriver.waitDrivervElementToBeClickable(driver, ElementsBrowser.byFILTERS());
        ElementsBrowser.elementFILTERS(driver).click();
        ElementsBrowser.elementFilterByTypeVideo(driver).click();
    }
    @Test
    public void step5() throws InterruptedException {
        sleep(100);
        BrowserDriver.waitInvisibilityOfElementLocated(driver,ElementsBrowser.byScreenOfFilters());
        BrowserDriver.waitDrivervElementToBeClickable(driver, ElementsBrowser.byFILTERS());
        ElementsBrowser.elementFILTERS(driver).click();
        ElementsBrowser.elementSortByViewCount(driver).click();
        sleep(100);
    }
    @Test
    public void step7() throws InterruptedException {
        sleep(1000);
        BrowserDriver.waitDrivervElementToBeClickable(driver,ElementsBrowser.videoRenderer());
        List<WebElement> testedVideo = driver.findElements(By.id("title-wrapper"));
        List<WebElement> a=driver.findElements(By.id("channel-info"));
        System.out.println(a.get(1).getText());
        testedVideo.get(1).click();
        System.out.println(testedVideo.size());

     //   Functions.videoSearch(driver,testedVideo,findOfVideoURL);


        System.out.println(selectedVideo);
    }
    @Test
    public void step8() throws InterruptedException {
        sleep(1000);
        BrowserDriver.waitVisibilityOfElementLocated(driver,ElementsBrowser.byPlayVideo());
        BrowserDriver.waitDrivervElementToBeClickable(driver,ElementsBrowser.byPlayVideo());
//        BrowserDriver.waitDrivervElementToBeClickable(driver,ElementsBrowser.bySkipAdButton());
//        while (!ElementsBrowser.skipAdButton(driver).isDisplayed()){
//            BrowserDriver.waitDrivervElementToBeClickable(driver,ElementsBrowser.bySkipAdButton());
//            if ( ElementsBrowser.skipAdButton(driver).isDisplayed()){
//                ElementsBrowser.skipAdButton(driver).click();
//            }
//            sleep(100);
//        }

        BrowserDriver.waitInvisibilityOfElementLocated(driver,ElementsBrowser.bySkipAdButton());
        ElementsBrowser.playVideo(driver).click();

    }
    @Test
    public void step9 () throws InterruptedException {
        sleep(1000);
        BrowserDriver.waitInvisibilityOfElementLocated(driver,ElementsBrowser.bySkipAdButton());
        if (ElementsBrowser.moreInformationAboutVideo(driver).isDisplayed()){
        ElementsBrowser.moreInformationAboutVideo(driver).click();
        }
        artistName= ElementsBrowser.channelDetails(driver).getText();
        System.out.println(artistName);
    }
    @AfterTest
    public void closeAllPages(){
        //driver.quit();
        // driver.close();
    }
}
