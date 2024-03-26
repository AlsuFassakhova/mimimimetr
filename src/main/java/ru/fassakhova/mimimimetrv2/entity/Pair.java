package ru.fassakhova.mimimimetrv2.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Pair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pairId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "first_cat_id")
    private Cat firstCat;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "second_cat_id")
    private Cat secondCat;
}