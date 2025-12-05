package nikolay.test.tests;

import nikolay.test.base.BaseTest;
import org.junit.jupiter.api.Test;

public class WidgetTest extends BaseTest {

    @Test
    public void addNewWidget() {
        loginPage.enterLogin("default").
            enterPassword("1q2w3e").
            submit().
            isSuccessMessageDisplayed();
        widgetPage.openWidgetPage()
            .openAddDashboard()
            .enterDashboardName("dashboard")
            .enterDashboardDescription("description")
            .clickDashboardAddButton()
            .isSuccessMessageDisplayed();
    }
}
