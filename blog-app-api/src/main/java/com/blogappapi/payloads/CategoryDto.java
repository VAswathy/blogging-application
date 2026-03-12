package com.codewithdurgesh.blogappapi.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long categoryId;

    @NotEmpty
    @Size(min=4,message="Title should atleast have 4 character")
    private String categoryTitle;

    @NotEmpty
    @Size(min=4, message="Description not elaborate")
    private String categoryDescription;
}
