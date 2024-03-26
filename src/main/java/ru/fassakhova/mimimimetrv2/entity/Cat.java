package ru.fassakhova.mimimimetrv2.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "cats")
public class Cat{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catId;
    @Column(name = "name")
    private String name;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "votes")
    private int votes;
}