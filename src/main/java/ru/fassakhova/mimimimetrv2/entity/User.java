package ru.fassakhova.mimimimetrv2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User extends AbstractEntity{

    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<VotePair> pairs = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!getId().equals(user.getId())) return false;
        if (!name.equals(user.name)) return false;
        return pairs.equals(user.pairs);
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + pairs.hashCode();
        return result;
    }
}
