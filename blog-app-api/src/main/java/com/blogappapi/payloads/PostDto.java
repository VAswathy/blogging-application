package com.codewithdurgesh.blogappapi.payloads;

import com.codewithdurgesh.blogappapi.model.Category;
import com.codewithdurgesh.blogappapi.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    @NotEmpty
    @Size(min=2,message="Title should be min 2 character")
    private String postTitle;

    @NotEmpty
    @Size(min=6,message="Title should be min 6 character")
    private String postContent;

    private String imageName;
    private Date addedDate;
    private UserDto user;
    private CategoryDto category;
}
