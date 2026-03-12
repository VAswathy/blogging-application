package com.codewithdurgesh.blogappapi.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotEmpty
    @Size(min=2,message="User Name should have min 2 character")
    private String name;

    @Email(message = "Email is not Valid !!")
    private String email;

    @NotEmpty
    @Size(min=8,max=16,message="Password should have atleast 8 character")
    private String password;

    @NotEmpty
    private String about;
}
