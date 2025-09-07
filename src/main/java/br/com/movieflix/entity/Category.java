package br.com.movieflix.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100 , nullable = false)
    private String name;


}
