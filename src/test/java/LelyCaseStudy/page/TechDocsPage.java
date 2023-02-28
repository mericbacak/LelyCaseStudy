package LelyCaseStudy.page;

import LelyCaseStudy.base.BasePage;
import LelyCaseStudy.page.Locators.TechDocsLocators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class TechDocsPage extends BasePage {

    public TechDocsPage(WebDriver driver) {

        super(driver);
    }

    public void Step2Search() throws InterruptedException {
        driver.navigate().to(TechDocsLocators.TechDocsURL);
        click((TechDocsLocators.CatalogList));
        Thread.sleep(2);
        SendKeys((TechDocsLocators.inputField), TechDocsLocators.SearchedKeywords);
        sendHotKey(TechDocsLocators.inputField, Keys.ENTER);

    }
    public void step2VerifyDocumentsandDownloadLinks() throws InterruptedException{
        ELementisExist(TechDocsLocators.ViewThisDocument1);
        ELementisExist(TechDocsLocators.ViewThisDocument2);
        ELementisExist(TechDocsLocators.Download1);
        ELementisExist(TechDocsLocators.Download2);

    }

    public boolean isFileDownloaded( String fileName) {
        String downloadPath="C:\\Users\\DELL\\Downloads\\";
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                //dirContents[i].delete();
                //Bulunduktan sonra isteğe göre silinebilir, test dizininin şişmemesi için.
                System.out.println(dirContents[i].getName());
                return true;
            }
        }
        return false;
    }


}

