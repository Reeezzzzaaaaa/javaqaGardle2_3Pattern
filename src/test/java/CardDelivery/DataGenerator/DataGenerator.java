package CardDelivery.DataGenerator;

import CardDelivery.Registration.RegistrationInfo;
import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@UtilityClass
public class DataGenerator {

    @UtilityClass
    public static class administrativeCenter {
        String[] city = {"Брянск", "Смоленск", "Курск", "Белгород", "Москва"};
    }

    @UtilityClass
    public static class Registration {
        public static RegistrationInfo generateInfo(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new RegistrationInfo(
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber(),
                    faker.address().city());
                    //faker.random(administrativeCenter.city)); // не понимаю как с faker.random() поступать
        }
    }

    @UtilityClass
    public static class Date {
        public static String generateDate(int days) {
            return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }
}

