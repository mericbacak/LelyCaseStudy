package LelyCaseStudy.page.Locators;

import org.openqa.selenium.By;

public class TechDocsLocators {

    public static final String TechDocsURL="https://www.lely.com/techdocs/";
    public static final By CatalogList = By.xpath("//span[text()='Type a product name']");

    public static final By inputField = By.xpath("//input[@type='search']");

    public static final String SearchedKeywords= "LUNA EUR";

    public static final By ViewThisDocument1 = By.xpath("(//a[contains(text(),'View this document')])[1]");

    public static final By ViewThisDocument2 = By.xpath("(//a[contains(text(),'View this document')])[2]");
    //(//a[contains(text(),'View this document')])[2]

    public static final By Download1=By.xpath("(//a[@class='button button-secondary icon-pdf'])[1]");
    public static final By Download2=By.xpath("(//a[@class='button button-secondary icon-pdf'])[2]");


}
