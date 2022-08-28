import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;

public class ChangeDateFakerTest {

    LoginPage login = new LoginPage();

    @BeforeEach
    void setUp() {login.openPage();}

    @Test
    void shouldBeValidTest() {

        Configuration.holdBrowserOpen=true;
        login.city("Брянск");  //faker.city() может генерировать города не являющиеся административными центрами, доставка карты в которые невозможна
        login.dateDelete();
        login.date(3);
        login.name();
        login.phone();
        login.agreement();
        login.button();
        login.shouldBe(appear, 5);
        login.shouldHave(3, 5, visible);
        login.dateDelete();
        login.date(10);
        login.button();
        login.replan();
        login.shouldBe(appear, 12);
        login.shouldHave(10, 12, visible);
    }
}
