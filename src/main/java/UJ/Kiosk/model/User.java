package UJ.Kiosk.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data // аннотация из библиотеки Lombok. автоматически создает  toString(), equals(), hashCode(), геттеры и сеттеры для всех полей класса.
public class User {
    private static Long idCounter = 0L; // Это счетчик для id,  потом нужно переписать, \
    // но это будет браться из баз данных, а ее пока нет, по этому на данный момент и так сойдет.

    private final Long id;
    private final boolean is_supervisor ; // Это для того чтобы был только один "хозяин", пока не придумал как это реализовать.

    @NotBlank // Анотации для валидации.
    private final String name;

    @NotBlank
    private final String surname;

    private final String login;

    @NotBlank
    private final String position;

    @NotBlank
    @Email
    private final String email;

    private final String phone;
    private final String address;

    @Past
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private final LocalDate birthday;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private final LocalDate hireDate;


}
