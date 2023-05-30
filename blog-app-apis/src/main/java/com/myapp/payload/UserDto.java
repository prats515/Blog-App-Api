package com.myapp.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private int id;
   @NotEmpty
   @Size(min=3, message = "Username must be min 3 chars")
    private String name;
    @Email(message="Email address not found")
    private String email;
    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must 3> <10")
    private String password;
    @NotNull
    private String about;


}
