import org.openqa.selenium.*;

import java.util.List;

public class Functions {
    public static void videoSearch(WebDriver driver , List<WebElement> testedVideo ,String findOfVideoURL  ){

        String selectedVideo ;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        int i = 0;
        do {
            selectedVideo = testedVideo.get(i).findElement(By.tagName("a")).getAttribute("href");
            System.out.println(findOfVideoURL.equals(selectedVideo));

            if(findOfVideoURL.equals(selectedVideo)){
                System.out.println(findOfVideoURL.equals(selectedVideo));
                System.out.println(ElementsBrowser.distributorDetails(driver).get(i).getText());
                testedVideo.get(i).click();
                return;
            }
            if (i == testedVideo.size()-1) {
                js.executeScript("window.scrollBy(0,200)");
            }
            testedVideo= driver.findElements(By.id("title-wrapper"));
            i++;
        }while (i < testedVideo.size());
    }
}
