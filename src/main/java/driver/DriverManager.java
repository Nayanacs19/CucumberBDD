package driver;

import static constants.StringConstrants.*;
import config.ConfigFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

@Before
    public static void setUp(){
        WebDriver driver;
    System.out.printf("testing driver");
        if (ConfigFactory.getConfig().browser().equalsIgnoreCase(CHROME)){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\nayan\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (ConfigFactory.getConfig().browser().equalsIgnoreCase(FIREFOX)) {
            FirefoxOptions browserOptions = new FirefoxOptions();
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("92");
            driver = new RemoteWebDriver(browserOptions);
        } else {
            driver = new EdgeDriver();
        }
        threadLocal.set(driver);
        getDriver().manage().window().maximize();
}

public static WebDriver getDriver(){
    return threadLocal.get();
}
@After
    public static void teardown(){
        getDriver().quit();
}



}
