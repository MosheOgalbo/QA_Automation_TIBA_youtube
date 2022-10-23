import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Functions {
    public static void videoSearch(WebDriver driver , List<WebElement> testedVideo ,String findOfVideoURL  ){
        String selectedVideo ;
        JavascriptExecutor js = (JavascriptExecutor)driver;

        for (int i = 0; i <= testedVideo.size() ; i++) {
            selectedVideo = testedVideo.get(i).findElement(By.tagName("a")).getAttribute("href");
            System.out.println(findOfVideoURL.equals(selectedVideo));

            if(findOfVideoURL.equals(selectedVideo)){
                System.out.println(findOfVideoURL.equals(selectedVideo));
                testedVideo.get(i).click();
                return;
            }
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "22");
            testedVideo= driver.findElements(By.id("title-wrapper"));

        }
    }
}
