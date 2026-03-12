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
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="user_name", nullable = false, length= 70)
    private String name;

    private String email;
    private String password;

    @Column(name="about_user", nullable = false, length= 500)
    private String about;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Post> posts=new ArrayList<>();
}
