import com.github.javafaker.service.RandomService;
import lombok.Data;

@Data
public class RegistrationInfo {
    private final String name;
    private final String phone;
    private final String city;
}