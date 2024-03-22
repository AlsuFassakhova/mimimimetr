package ru.fassakhova.mimimimetrv2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
public class VotePair extends AbstractEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "first_cat_id")
    private Cat firstCat;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "second_cat_id")
    private Cat secondCat;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotePair votePair = (VotePair) o;

        if (!getId().equals(votePair.getId())) return false;
        if (!firstCat.equals(votePair.firstCat)) return false;
        return secondCat.equals(votePair.secondCat);
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + firstCat.hashCode();
        result = 31 * result + secondCat.hashCode();
        return result;
    }
}