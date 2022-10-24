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

    /* Searches for the selected video, if not found selects the first video*/
    public static void videoSearch(WebDriver driver , List<WebElement> testedVideo ,String findOfVideoURL  ) throws InterruptedException {
        int i = 0;
        try {
            String selectedVideo;
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,100)");

            do {
                selectedVideo = testedVideo.get(i).findElement(By.tagName("a")).getAttribute("href");
                //System.out.println(findOfVideoURL.equals(selectedVideo));

                if (findOfVideoURL.equals(selectedVideo)) {
                    System.out.println(findOfVideoURL.equals(selectedVideo));
                    System.out.println(ElementsBrowser.distributorDetails(driver).get(i).getText());
                    testedVideo.get(i).click();
                    return;
                }
                js.executeScript("window.scrollBy(0,100)");
                sleep(100);
                if (i == testedVideo.size() - 2) {
                    js.executeScript("window.scrollBy(0,1000)");
                    sleep(1000);
                }
                testedVideo = driver.findElements(By.id("title-wrapper"));
                i++;
                if (i>1000){
                    System.out.println(" Video not found ");
                    System.out.println(ElementsBrowser.distributorDetails(driver).get(i).getText());
                    testedVideo.get(i).click();
                    return;
                }
            } while (i < ElementsBrowser.testedVideo(driver).size());
            System.out.println(ElementsBrowser.testedVideo(driver).size()+"\n"+testedVideo);

        } catch (Exception e) {
            System.out.println(" Video not found ");
            System.out.println(ElementsBrowser.distributorDetails(driver).get(i).getText());
            testedVideo.get(i).click();
        }
    }
    public static void skippingAd (WebDriver driver) throws InterruptedException {
        sleep(1000);
        try {
            int i = 0;
            while (ElementsBrowser.skipAdButton(driver).isEnabled()) {
                sleep(1000);

               BrowserDriver.waitDrivervElementToBeClickable(driver, ElementsBrowser.bySkipAdButton());
                if (ElementsBrowser.skipAdButton(driver).isDisplayed()) {
                    BrowserDriver.waitDrivervElementToBeClickable(driver, ElementsBrowser.bySkipAdButton());
                    ElementsBrowser.skipAdButton(driver).click();
                   BrowserDriver.waitInvisibilityOfElementLocated(driver,ElementsBrowser.bySkipAdButton());
                    i++;
                }
                if (i > 3) {
                    return;
                }

            }
        }catch (Exception e){
            BrowserDriver.waitInvisibilityOfElementLocated(driver,ElementsBrowser.bySkipAdButton());
        }
    }
}
