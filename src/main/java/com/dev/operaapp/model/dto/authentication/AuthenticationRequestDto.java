package com.dev.operaapp.model.dto.authentication;

import com.dev.operaapp.annotation.EmailConstraint;
import com.dev.operaapp.annotation.PasswordConstraint;
import javax.validation.constraints.Size;

@PasswordConstraint.List({
        @PasswordConstraint(
                field = "password",
                fieldMatch = "repeatPassword",
                message = "Password do not match"
        )
})
public class AuthenticationRequestDto {
    @Size(min = 4, message = "The email length should be longer then 4")
    @EmailConstraint
    private String email;
    @Size(min = 4, message = "The password length should be longer then 4")
    private String password;
    @Size(min = 4)
    private String repeatPassword;

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
