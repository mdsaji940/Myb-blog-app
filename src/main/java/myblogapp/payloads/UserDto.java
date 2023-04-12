package myblogapp.payloads;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserDto {

    private Long id;

    @NotEmpty
    @Size(min = 4, message = "User name must be minimum 4")
    @Size(max = 15, message = "user name must be maximum 15")
    private String name;

    @Email(message = "Email is not valid")
    @NotEmpty
    private String email;

    @NotNull
    @Size(min = 3, max = 10, message = "password must be between 3 to 10 characters")
    private String password;
    @NotNull
    private String about;
}
