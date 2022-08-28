package DeliveryCard.LoginPage;

import DeliveryCard.RegistrationInfo.*;
import com.codeborne.selenide.Condition;
import DeliveryCard.dataGenerator.*;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    RegistrationInfo info = DataGenerator.Registration.generateInfo("ru");


    public String generationDate(int date) {
        return LocalDate.now().plusDays(date).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


    public void openPage() {open("http://localhost:9999/");}
    public void city(String city) {$x("//*[@data-test-id='city']//*[@placeholder='Город']").setValue(city);}
    public void dateDelete() {$x("//*[@data-test-id='date']//*[@placeholder='Дата встречи']").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);}
    public void date(int date) {$x("//*[@data-test-id='date']//*[@placeholder='Дата встречи']").setValue(generationDate(date));}
    public void name() {$x("//*[@data-test-id='name']//*[@class='input__control']").setValue(info.getName());}
    public void phone() {$x("//*[@data-test-id='phone']//*[@class='input__control']").setValue(info.getPhone());}
    public void agreement() {$x("//*[@data-test-id='agreement']//*[@class='checkbox__box']").click();}
    public void button() {$x("//*[@class='button__content']//ancestor::button").click();}
    public void shouldBe(Condition appear, int seconds) {$x("//*[@data-test-id='success-notification']//*[@class='notification__content']").shouldBe(appear, Duration.ofSeconds(seconds));}
    public void shouldHave(int date, int seconds, Condition visible) {$x("//*[@data-test-id='success-notification']//*[@class='notification__content']").shouldHave(Condition.text(generationDate(date)), Duration.ofSeconds(seconds)).shouldBe(visible);}
    public void replan() {$x("//*[@data-test-id='replan-notification']//*[@role='button']").click();}
}
