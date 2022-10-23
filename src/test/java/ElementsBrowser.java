import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsBrowser {
    public  static By previewBar(){
        return By.id("chips");
    }
    public static  By bycssSelectorSearchFie( ){
        return By.cssSelector("ytd-searchbox#search");
    }
    public static WebElement searchField(WebDriver driver){
        return  driver.findElement(bycssSelectorSearchFie());
    }
    public static By byFILTERS(){
        return By.tagName("ytd-toggle-button-renderer");
    }
    public static  WebElement elementFILTERS(WebDriver driver){
        return driver.findElement(byFILTERS());
    }
    public static By byScreenOfFilters(){
        return  By.id("collapse-content");
    }
    public static By byXpathFilterByTypeVideo(){
        return By.xpath(
                "//ytd-search-filter-group-renderer[2]//ytd-search-filter-renderer[1]//a[1]//div[1]//yt-formatted-string[1]");
    }
    public static WebElement elementFilterByTypeVideo (WebDriver driver){
        return driver.findElement(byXpathFilterByTypeVideo());
    }
    public static  By byXpathSortByViewCount(){
        return By.xpath("//ytd-search-filter-group-renderer[5]//ytd-search-filter-renderer[3]//a[1]//div[1]//yt-formatted-string[1]");
    }
    public static WebElement elementSortByViewCount(WebDriver driver){
        return driver.findElement(byXpathSortByViewCount());
    }
    public static  By videoRenderer (){
        return By.tagName("ytd-video-renderer");
    }
    public static By byPlayVideo(){
        return By.id("movie_player");
    }
    public static WebElement playVideo (WebDriver driver){
        return driver.findElement(byPlayVideo());
    }
    public static By  bySkipAdButton(){
        return By.className("ytp-ad-preview-slot");
    }
    public static WebElement skipAdButton(WebDriver driver){
        return driver.findElement(bySkipAdButton());
    }

    public static WebElement channelDetails (WebDriver driver){
        return driver.findElement(By.id("meta-contents"));
    }
    public  static  WebElement moreInformationAboutVideo(WebDriver driver){
        return channelDetails(driver).findElement(By.id("more"));
}

}
