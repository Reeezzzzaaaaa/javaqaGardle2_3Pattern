package сardDelivery.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import сardDelivery.data.DataGenerator;
import сardDelivery.data.RegistrationInfo;
import сardDelivery.pages.LoginPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class ChangeDateFakerTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void openPage() {
        open("http://localhost:9999/");
    }

    RegistrationInfo info = DataGenerator.Data.generateInfo("ru");

    @Test
    void shouldBeValidTest() {

        LoginPage login = new LoginPage();
        login.planDate(info.getCity(), 3, info.getName(), info.getPhone(), appear, 12);
        login.shouldHave(3, 12, visible);
        login.rePlanDate(10, appear, 12);
        login.shouldHave(10, 12, visible);
        login.replan();
    }
}
