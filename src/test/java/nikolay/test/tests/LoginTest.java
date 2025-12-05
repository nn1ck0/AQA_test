package nikolay.test.tests;

import nikolay.test.base.BaseTest;
import org.junit.jupiter.api.Test;


public class LoginTest extends BaseTest {

    @Test
    public void testPositiveLogin(){
         loginPage.enterLogin("default").
             enterPassword("1q2w3e").
             submit().
             isSuccessMessageDisplayed();
    }

    @Test
    public void testNegativeLogin(){
        loginPage.enterLogin("invalidUser")
            .enterPassword("wrongPass")
            .submit()
            .isErrorMessageDisplayed();
    }
}
