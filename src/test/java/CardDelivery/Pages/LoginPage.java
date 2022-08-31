package CardDelivery.Pages;

import CardDelivery.DataGenerator.DataGenerator;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    public void openPage() {open("http://localhost:9999/");}
    public void city(String city) {$x("//*[@data-test-id='city']//*[@placeholder='Город']").setValue(city);}
    public void dateDelete() {$x("//*[@data-test-id='date']//*[@placeholder='Дата встречи']").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);}
    public void date(int date) {$x("//*[@data-test-id='date']//*[@placeholder='Дата встречи']").setValue(DataGenerator.Date.generateDate(date));}
    public void name(String name) {$x("//*[@data-test-id='name']//*[@class='input__control']").setValue(name);}
    public void phone(String phone) {$x("//*[@data-test-id='phone']//*[@class='input__control']").setValue(phone);}
    public void agreement() {$x("//*[@data-test-id='agreement']//*[@class='checkbox__box']").click();}
    public void button() {$x("//*[@class='button__content']//ancestor::button").click();}
    public void shouldBe(Condition appear, int seconds) {$x("//*[@data-test-id='success-notification']//*[@class='notification__content']").shouldBe(appear, Duration.ofSeconds(seconds));}
    public void shouldHave(int date, int seconds, Condition visible) {$x("//*[@data-test-id='success-notification']//*[@class='notification__content']").shouldHave(Condition.text(DataGenerator.Date.generateDate(date)), Duration.ofSeconds(seconds)).shouldBe(visible);}
    public void replan() {$x("//*[@data-test-id='replan-notification']//*[@role='button']").click();}

    public LoginPage getPlanDate(String city, int date, String name, String phone, Condition appear, int seconds) {
        city(city);
        dateDelete();
        date(date);
        name(name);
        phone(phone);
        agreement();
        button();
        shouldBe(appear, seconds);
        return new LoginPage();
    }

    public LoginPage getRePlanDate(int date, Condition appear, int seconds) {
        dateDelete();
        date(date);
        button();
        replan();
        shouldBe(appear, seconds);
        return new LoginPage();
    }
}
