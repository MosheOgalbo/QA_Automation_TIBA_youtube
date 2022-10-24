import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
        sleep(100);
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
        sleep(1000);
    }
    @Test
    public void step7() throws InterruptedException {
        sleep(1000);
        BrowserDriver.waitDrivervElementToBeClickable(driver,ElementsBrowser.videoRenderer());

        // The dynamite scrolling video find function does not work well
        // Functions.videoSearch(driver,ElementsBrowser.testedVideo(driver),findOfVideoURL);
        System.out.println(ElementsBrowser.distributorDetails(driver).get(3).getText());
        ElementsBrowser.testedVideo(driver).get(3).click();
        //BrowserDriver.waitInvisibilityOfElementLocated(driver, By.cssSelector("style-scope ytd-mini-guide-renderer"));

    }
    @Test
    public void step8() throws InterruptedException {
        sleep(1000);

        BrowserDriver.waitVisibilityOfElementLocated(driver,ElementsBrowser.byPlayVideo());
        BrowserDriver.waitDrivervElementToBeClickable(driver,ElementsBrowser.byPlayVideo());
        Functions.scrollDown(driver);
        Functions.skippingAd(driver);
        ElementsBrowser.playVideo(driver).click();
    }
    @Test
    public void step9 () throws InterruptedException {
        sleep(1000);
        BrowserDriver.waitInvisibilityOfElementLocated(driver,ElementsBrowser.bySkipAdButton());
        Functions.scrollDown(driver);
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
