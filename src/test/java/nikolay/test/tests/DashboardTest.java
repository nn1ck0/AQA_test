package nikolay.test.tests;

import nikolay.test.base.BaseTest;
import org.junit.jupiter.api.Test;

public class DashboardTest extends BaseTest {

    @Test
    public void addNewWidget() {
        loginPage.enterLogin("default").
            enterPassword("1q2w3e").
            submit().
            isSuccessMessageDisplayed();
        widgetPage.openDashboardPage()
            .openAddDashboard()
            .enterDashboardName("dashboard")
            .enterDashboardDescription("description")
            .clickDashboardAddButton()
            .isSuccessMessageDisplayed();
    }
}
