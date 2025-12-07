package nikolay.test.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final By LOGIN = By.xpath("//input[@name='login']");
    private static final By PASSWORD = By.xpath("//input[@name='password']");
    private static final By SUBMIT_BUTTON = By.xpath("//button[@type='submit']");
    protected static final By MESSAGE_LOGIN_ERROR = By.xpath("//h2[@class = '_title_14lm6_32']");
    protected static final By MESSAGE_LOGIN_SUCCESS = By.xpath("//h2[@class = '_title_14lm6_32']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Ввод логина")
    public LoginPage enterLogin(String login) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN)).clear();
        driver.findElement(LOGIN).sendKeys(login);
        return this;
    }

    @Step("Ввод пароля")
    public LoginPage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD)).clear();
        driver.findElement(PASSWORD).sendKeys(password);
        return this;
    }

    @Step("Нажатие кнопки войти")
    public LoginPage submit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUBMIT_BUTTON)).click();
        driver.findElement(SUBMIT_BUTTON).click();
        return this;
    }

    @Step("Сообщение, что дашбоорд создан успешно")
    public boolean isErrorMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_LOGIN_ERROR)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isSuccessMessageDisplayed() {
        try{
            return wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_LOGIN_SUCCESS)).isDisplayed();
        } catch (TimeoutException e){
            return false;
        }
    }
}
