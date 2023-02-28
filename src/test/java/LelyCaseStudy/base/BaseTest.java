package LelyCaseStudy.base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {

    public WebDriver driver;
    public ChromeOptions getOptions() {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        prefs.put("profile.managed_default_content_settings.javascript", 1);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("download.prompt_for_download",false);
        prefs.put("download.default_directory", "C:\\Users\\DELL\\Downloads\\");
        LoggingPreferences chromeLogPrefs = new LoggingPreferences();
        chromeLogPrefs.enable(LogType.PERFORMANCE, Level.OFF);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        chromeOptions.setCapability(ChromeDriverService.CHROME_DRIVER_VERBOSE_LOG_PROPERTY, "true");
        chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, chromeLogPrefs);
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        chromeOptions.addArguments("--no-sandbox","--disable-gpu", "--disable-logging", "--disable-dev-shm-usage");
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setHeadless(Boolean.getBoolean("headless"));
        chromeOptions.setExperimentalOption("prefs", prefs);
        return chromeOptions;
    }

    @BeforeTest
    public void before() throws InterruptedException {
        getOptions();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.lely.com/en");
    }

    @AfterTest
    public void after() throws InterruptedException {
        Thread.sleep(2);
        driver.quit();
    }
}
