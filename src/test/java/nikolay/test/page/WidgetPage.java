package nikolay.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WidgetPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final By DASHBOARDS_BUTTON = By.xpath("//a[@href='#default_personal/dashboard']");
    private static final By ADD_DASHBOARD_BUTTON = By.xpath("//button[@class='ghostButton__ghost-button--r7c9T ghostButton__color-topaz--Z_OvX with-icon ghostButton__filled-icon--HoBWw ghostButton__mobile-minified--d60VQ']");
    private static final By DASHBOARD_NAME = By.xpath("//input[@placeholder='Enter dashboard name']");
    private static final By DASHBOARD_DESCRIPTION = By.xpath("//textarea[@placeholder='Enter dashboard description']");
    private static final By DASHBOARD_ADD_BUTTON = By.xpath("//button[@class='bigButton__big-button--BmG4Q bigButton__color-booger--EpRlL']");
    private static final By DASHBOARD_ADD_SUCCESS = By.xpath("//h2[@class = '_title_14lm6_32']");
    private static final By DASHBOARD_LIST = By.xpath("//div[@class='gridCell__grid-cell--EIqeC gridCell__align-left--DFXWN dashboardTable__description--tHp7Q']");

    public WidgetPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WidgetPage openWidgetPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARDS_BUTTON));
        driver.findElement(DASHBOARDS_BUTTON).click();
        return this;
    }

    public WidgetPage openAddDashboard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_DASHBOARD_BUTTON));
        driver.findElement(ADD_DASHBOARD_BUTTON).click();
        return this;
    }

    public WidgetPage enterDashboardName(String dashboardName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_NAME));
        driver.findElement(DASHBOARD_NAME).sendKeys(dashboardName);
        return this;
    }

    public WidgetPage enterDashboardDescription(String dashboardDescription) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_DESCRIPTION));
        driver.findElement(DASHBOARD_DESCRIPTION).sendKeys(dashboardDescription);
        return this;
    }

    public WidgetPage clickDashboardAddButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_ADD_BUTTON));
        driver.findElement(DASHBOARD_ADD_BUTTON).click();
        return this;
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_ADD_SUCCESS)).isDisplayed();
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isDashboardExistInDashboardList(){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_LIST));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
