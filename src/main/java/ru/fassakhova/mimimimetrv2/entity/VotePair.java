package ru.fassakhova.mimimimetrv2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class VotePair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pairId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "first_cat_id")
    private Cat firstCat;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "second_cat_id")
    private Cat secondCat;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotePair votePair = (VotePair) o;

        if (!pairId.equals(votePair.pairId)) return false;
        if (!firstCat.equals(votePair.firstCat)) return false;
        return secondCat.equals(votePair.secondCat);
    }

    @Override
    public int hashCode() {
        int result = pairId.hashCode();
        result = 31 * result + firstCat.hashCode();
        result = 31 * result + secondCat.hashCode();
        return result;
    }
}