package com.codewithdurgesh.blogappapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(name="title",nullable = false,length=80)
    private String postTitle;

    @Column(name="content",nullable = false,length=10000)
    private String postContent;

    @Column(name="image_name",nullable = false,length=80)
    private String imageName;

    @Column(name="created_date",nullable = false)
    private Date addedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
