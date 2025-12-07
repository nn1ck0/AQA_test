package nikolay.test.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import nikolay.test.base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LoginTest extends BaseTest {

    @Test
    @Story("Успешная авторизация с учетом валидных данных")
    @DisplayName("Авторизация с валидными данными")
    @Owner("Nikolay")
    @TmsLink("@nn1ck0")
    @Severity(SeverityLevel.NORMAL)
    @Description("Описание положительного теста....")
    public void testPositiveLogin(){
         loginPage.enterLogin("default").
             enterPassword("1q2w3e").
             submit().
             isSuccessMessageDisplayed();
    }

    @Test
    @Story("Неуспешная авторизация с учетом невалидных данных")
    @DisplayName("Авторизация с невалидными данными")
    @Owner("Nikolay")
    @TmsLink("@nn1ck0")
    @Severity(SeverityLevel.NORMAL)
    @Description("Описание негативного теста....")
    public void testNegativeLogin(){
        loginPage.enterLogin("invalidUser")
            .enterPassword("wrongPass")
            .submit()
            .isErrorMessageDisplayed();
    }
}
