package com.codewithdurgesh.blogs.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name", nullable = false, length=70)
    private String name;

    @Column(name = "user_email", nullable = false, length=50)
    private String email;

    @Column(name = "password", nullable = false, length=50)
    private String password;

    @Column(name = "password", nullable = false, length=500)
    private String about;

}