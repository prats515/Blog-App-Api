package com.myapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Posts")
@NoArgsConstructor
@Setter
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    @Column(name="Post_Title")
    private String title;
    @Column(name="Post_Content", length = 1000)
    private String content;
    private String imageName;
    private Date addedDate;

    @ManyToOne
    private User user ;
    @ManyToOne
    @JoinColumn(name="Category_Id")
    private Category category;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comment> comment=new HashSet<>();
}
