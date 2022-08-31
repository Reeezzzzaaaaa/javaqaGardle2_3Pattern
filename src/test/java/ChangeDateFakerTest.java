import CardDelivery.DataGenerator.DataGenerator;
import CardDelivery.Pages.LoginPage;
import CardDelivery.Registration.RegistrationInfo;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;

public class ChangeDateFakerTest {

    @BeforeEach
    void setUp() {login.openPage();}

    LoginPage login = new LoginPage();
    RegistrationInfo info = DataGenerator.Registration.generateInfo("ru");

    @Test
    void shouldBeValidTest() {

        login.getPlanDate(info.getCity(),3, info.getName(), info.getPhone(), appear, 12);
        login.shouldHave(3, 12, visible);
        login.getRePlanDate(10, appear, 12);
        login.shouldHave(10, 12, visible);
    }
}
