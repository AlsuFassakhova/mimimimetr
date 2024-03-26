package ru.fassakhova.mimimimetrv2.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "votes")
public class Vote{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;
    @ManyToOne
    private Pair pair;
    @Column(name = "user_name")
    private String userName;
}
