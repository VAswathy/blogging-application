package com.codewithdurgesh.blogappapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name="title",nullable = false,length = 100)
    private String categoryTitle;

    @Column(name="description",nullable = false,length = 1000)
    private String categoryDescription;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Post> posts=new ArrayList<>();

}
