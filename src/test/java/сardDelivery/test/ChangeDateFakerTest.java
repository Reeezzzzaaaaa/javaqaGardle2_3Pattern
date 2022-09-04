package сardDelivery.test;

import сardDelivery.data.DataGenerator;
import сardDelivery.data.RegistrationInfo;
import сardDelivery.pages.LoginPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;

public class ChangeDateFakerTest {

    LoginPage login = new LoginPage();
    RegistrationInfo info = DataGenerator.Data.generateInfo("ru");

    @Test
    void shouldBeValidTest() {

        Configuration.holdBrowserOpen = true;
        login.planDate(info.getCity(), 3, info.getName(), info.getPhone(), appear, 12);
        login.shouldHave(3, 12, visible);
        login.rePlanDate(10, appear, 12);
        login.shouldHave(10, 12, visible);
        login.replan();
    }
}
