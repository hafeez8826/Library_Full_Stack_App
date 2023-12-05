package com.hz.springbootlibrary.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;
    @Column(name = "copies")
    private String copies;
    @Column(name = "copies_available")
    private String copiesAvailable;
    @Column(name = "category")
    private String category;
    @Column(name = "img")
    private String img;
}
