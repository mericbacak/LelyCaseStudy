package LelyCaseStudy.page;

import LelyCaseStudy.base.BasePage;
import LelyCaseStudy.page.Locators.Chapter2CaseAPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Chapter2CaseAPage extends BasePage {

    public Chapter2CaseAPage(WebDriver driver) {
        super(driver);

    }

    Logger mylog = Logger.getLogger(Chapter2CaseAPage.class.getName());

    public void Step1Search() throws InterruptedException {
        click((Chapter2CaseAPageLocators.SearchIcon));
        Thread.sleep(2);
        SendKeys((Chapter2CaseAPageLocators.HomePageInputField), Chapter2CaseAPageLocators.SearchedText);
        Thread.sleep(2);
        click(Chapter2CaseAPageLocators.SearchButton);

    }

    public void step1VerifytWordinDescription() throws InterruptedException {
        //FindElementCount(By.xpath(Chapter2CaseAPageLocators.itemDescription));
        //FindSearchResultPageCount(By.xpath(Chapter2CaseAPageLocators.pageNumbers));
        int elementsize=10;
        for (int count2=1;count2<=3;count2++) {
            if (count2==3)
            {
                elementsize=9;
            }
            for (int count = 1; count <= elementsize; count = count + 1) {
                String key = String.valueOf(count);
                WebDriverWait waiter = new WebDriverWait(driver, 30);
                WebElement element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Chapter2CaseAPageLocators.itemDescription + key + "]")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
                String DescriptionText = element.getText();
                String Kewyord = Chapter2CaseAPageLocators.SearchedText;
                String Kewyord2 = Chapter2CaseAPageLocators.SearchedText2;
                if (DescriptionText.contains(Kewyord) || DescriptionText.contains(Kewyord2)) {

                    mylog.log(Level.INFO, Kewyord + " found in item description, item is " + DescriptionText);
                    //System.out.println(Kewyord+" found in item description, item is "+DescriptionText);
                    //mylog.info(Kewyord+" found in item description, item is "+DescriptionText);
                } else {
                    mylog.log(Level.WARNING, Kewyord + " not found in item description, item is " + DescriptionText);
                    //mylog.warn(Kewyord+" nout found in item description, item is "+DescriptionText);
                    //System.out.println(Kewyord+" not found in item description, item is "+DescriptionText);
                }

                //her bir item descripton için bu şekilde dönülür
                //(//p[@class='item-description'])[count]
            }
            if(count2<3){
                click(Chapter2CaseAPageLocators.ResultsNextButton);
                Thread.sleep(2);
            }
        }
    }
}
