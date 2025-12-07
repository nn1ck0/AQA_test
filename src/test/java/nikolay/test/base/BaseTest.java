package nikolay.test.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import nikolay.test.page.LoginPage;
import nikolay.test.page.DashboardPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String BASE_URL = "https://demo.reportportal.io/ui/#login";

    protected LoginPage loginPage;
    protected DashboardPage widgetPage;

    @BeforeEach
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverManager.chromedriver().setup();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver, wait);
        widgetPage = new DashboardPage(driver, wait);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }


}
