package UJ.Kiosk.model.User;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@NotNull
@ApiModel(description = "User")

public class User implements IUser {
    private final int id;

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
