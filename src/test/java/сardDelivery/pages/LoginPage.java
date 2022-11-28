package сardDelivery.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;
import сardDelivery.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    public void planDate(String city, int date, String name, String phone, Condition appear, int seconds) {
        $x("//*[@data-test-id='city']//*[@placeholder='Город']").setValue(city);
        $x("//*[@data-test-id='date']//*[@placeholder='Дата встречи']").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $x("//*[@data-test-id='date']//*[@placeholder='Дата встречи']").setValue(DataGenerator.Data.generateDate(date));
        $x("//*[@data-test-id='name']//*[@class='input__control']").setValue(name);
        $x("//*[@data-test-id='phone']//*[@class='input__control']").setValue(phone);
        $x("//*[@data-test-id='agreement']//*[@class='checkbox__box']").click();
        $x("//*[@class='button__content']//ancestor::button").click();
        $x("//*[@data-test-id='success-notification']//*[@class='notification__content']").shouldBe(appear, Duration.ofSeconds(seconds));
    }

    public void rePlanDate(int date, Condition appear, int seconds) {
        $x("//*[@data-test-id='date']//*[@placeholder='Дата встречи']").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $x("//*[@data-test-id='date']//*[@placeholder='Дата встречи']").setValue(DataGenerator.Data.generateDate(date));
        $x("//*[@class='button__content']//ancestor::button").click();
        $x("//*[@data-test-id='success-notification']//*[@class='notification__content']").shouldBe(appear, Duration.ofSeconds(seconds));
    }

    public void shouldHave(int date, int seconds, Condition visible) {
        $x("//*[@data-test-id='success-notification']//*[@class='notification__content']").shouldHave(Condition.text(DataGenerator.Data.generateDate(date)), Duration.ofSeconds(seconds)).shouldBe(visible);
    }

    public void replan() {
        $x("//*[@data-test-id='replan-notification']//*[@role='button']").click();
    }
}
