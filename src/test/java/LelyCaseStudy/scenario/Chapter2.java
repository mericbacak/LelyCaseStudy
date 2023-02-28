package LelyCaseStudy.scenario;

import LelyCaseStudy.base.BaseTest;
import LelyCaseStudy.page.Chapter2CaseAPage;
import LelyCaseStudy.page.Locators.TechDocsLocators;
import LelyCaseStudy.page.TechDocsPage;

import org.testng.annotations.Test;

public class Chapter2 extends BaseTest {
    Chapter2CaseAPage homePage = new Chapter2CaseAPage(driver);
    TechDocsPage techpage= new TechDocsPage(driver);
    @Test
    public void Chapter2CaseA() throws InterruptedException {

        homePage.Step1Search();
        homePage.step1VerifytWordinDescription();
    }
    @Test
    public void Chapter2CaseB() throws InterruptedException {

        techpage.Step2Search();
        techpage.step2VerifyDocumentsandDownloadLinks();
        techpage.click(TechDocsLocators.ViewThisDocument1);
        Thread.sleep(2000);
        techpage.CloseOpenedTab();
        techpage.click(TechDocsLocators.ViewThisDocument1);
        Thread.sleep(2000);
        techpage.CloseOpenedTab();
        techpage.click(TechDocsLocators.Download1);
        //file download
        Thread.sleep(5000);
        techpage.isFileDownloaded("D-S006VT_-.pdf");
        techpage.click(TechDocsLocators.Download2);
        //file download
        Thread.sleep(5000);
        techpage.isFileDownloaded("D-S032VT_-.pdf");
    }

}
