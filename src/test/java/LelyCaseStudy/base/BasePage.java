package LelyCaseStudy.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasePage {


    public WebDriver driver;
    public Logger mylog = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver){
        this.driver = driver;
    }


    public void click(By by){
        WebDriverWait waiter = new WebDriverWait(driver, 30);
        WebElement element = waiter.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }

    public void SendKeys(By by, String value){
        WebDriverWait waiter = new WebDriverWait(driver, 30);
        WebElement element = waiter.until(ExpectedConditions.visibilityOfElementLocated(by));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public int FindElementCount(By by){
       WebDriverWait waiter = new WebDriverWait(driver, 30);
       List<WebElement> element = (List<WebElement>) waiter.until(ExpectedConditions.visibilityOfElementLocated(by));
        int ElementCount= element.size();
        return ElementCount;
    }

    public int FindSearchResultPageCount(By by) throws InterruptedException {
        int PageCount=0;
        WebDriverWait waiter = new WebDriverWait(driver, 30);
        WebElement element = waiter.until(ExpectedConditions.visibilityOfElementLocated(by));
        String pageNumber = element.getText();
        PageCount= Integer.parseInt(pageNumber);
        return PageCount;
        }
        public void sendHotKey(By by, Keys Key) throws InterruptedException {
            WebDriverWait waiter = new WebDriverWait(driver, 30);
            WebElement element = waiter.until(ExpectedConditions.visibilityOfElementLocated(by));
            element.sendKeys(Key);
            Thread.sleep(2);
        }

        public void ELementisExist(By by) {
            WebDriverWait waiter = new WebDriverWait(driver, 30);
            WebElement element = waiter.until(ExpectedConditions.visibilityOfElementLocated(by));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            Boolean exist= element.isDisplayed();
            if(exist.equals(Boolean.TRUE))
            {
                System.out.println(element+" öğesi bulunmuştur.");
            }
            else {
                System.out.println(element+" öğesi görüntülenmemektedir");
            }


        }
        public void CloseOpenedTab(){

            Actions action = new Actions(driver);
            action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
            action.keyDown(Keys.CONTROL).sendKeys("W");

        }
}


