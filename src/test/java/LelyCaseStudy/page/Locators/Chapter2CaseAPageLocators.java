package LelyCaseStudy.page.Locators;

import org.openqa.selenium.By;

public class Chapter2CaseAPageLocators {
    public static final By SearchIcon = By.xpath("//div[@class='header-navigation-button__label' and text()='Search']");
    public static final By HomePageInputField= By.xpath("//input[@id='global-search']");
    public  static final By SearchButton = By.xpath(("//button[@type='submit' and text()='Search']"));
        //public static final String itemDescription = "//p[@class='item-description']";
        public static final String pageNumbers="//a[@class='page-link']";
        public static final String itemDescription = "(//p[@class='item-description'])[";
    public static final By ResultsNextButton= By.xpath("//a[@class='page-link' and contains(text(),'Next')]");
    public static final String SearchedText ="Happy";
    public static final String SearchedText2 ="happy";
}
