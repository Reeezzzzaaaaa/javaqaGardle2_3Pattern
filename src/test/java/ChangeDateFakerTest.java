import CardDelivery.dataGenerator.DataGenerator;
import CardDelivery.pages.LoginPage;
import CardDelivery.registration.RegistrationInfo;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;

public class ChangeDateFakerTest {

    @BeforeEach
    void setUp() {login.openPage();}

    LoginPage login = new LoginPage();
    RegistrationInfo info = DataGenerator.Registration.generateInfo("ru");

    @Test
    void shouldBeValidTest() {

        Configuration.holdBrowserOpen=true;
        login.planDate(info.getCity(),3, info.getName(), info.getPhone(), appear, 12);
        login.shouldHave(3, 12, visible);
        login.rePlanDate(10, appear, 12);
        login.shouldHave(10, 12, visible);
        login.replan();
    }
}
