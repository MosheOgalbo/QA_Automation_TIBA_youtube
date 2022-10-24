import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Thread.sleep;

public class Functions {
    public static void scrollDown(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50)");
    }
    public static void videoSearch(WebDriver driver , List<WebElement> testedVideo ,String findOfVideoURL  ) throws InterruptedException {

        String selectedVideo ;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50)");
        int i = 0;
        do {
            selectedVideo = testedVideo.get(i).findElement(By.tagName("a")).getAttribute("href");
            //System.out.println(findOfVideoURL.equals(selectedVideo));

            if(findOfVideoURL.equals(selectedVideo)){
                System.out.println(findOfVideoURL.equals(selectedVideo));
                System.out.println(ElementsBrowser.distributorDetails(driver).get(i).getText());
                testedVideo.get(i).click();
                return;
            }
            js.executeScript("window.scrollBy(0,50)");
            sleep(100);
            if (i == testedVideo.size()-2) {
                js.executeScript("window.scrollBy(0,2000)");

            }
            testedVideo= driver.findElements(By.id("title-wrapper"));
            i++;
        }while (i < driver.findElements(By.id("title-wrapper")).size());
        System.out.println(ElementsBrowser.testedVideo(driver).size());
    }

    public static void skippingAd (WebDriver driver) throws InterruptedException {
      //  BrowserDriver.waitDrivervElementToBeClickable(driver,ElementsBrowser.bySkipAdButton());
        int i=0;
        sleep(1000);
        while (ElementsBrowser.skipAdButton(driver).isDisplayed()){
            sleep(1000);
            BrowserDriver.waitDrivervElementToBeClickable(driver,ElementsBrowser.bySkipAdButton());
            if ( ElementsBrowser.skipAdButton(driver).isDisplayed()){
                BrowserDriver.waitDrivervElementToBeClickable(driver,ElementsBrowser.bySkipAdButton());
                ElementsBrowser.skipAdButton(driver).click();
                //BrowserDriver.waitInvisibilityOfElementLocated(driver,ElementsBrowser.bySkipAdButton());
                i++;
            }
            if (i>3){
                return;
            }

       }
    }
}
