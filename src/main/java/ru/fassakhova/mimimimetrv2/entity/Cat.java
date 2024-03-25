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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (votes != cat.votes) return false;
        if (!catId.equals(cat.catId)) return false;
        if (!name.equals(cat.name)) return false;
        return imageUrl.equals(cat.imageUrl);
    }

    @Override
    public int hashCode() {
        int result = catId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + imageUrl.hashCode();
        result = 31 * result + votes;
        return result;
    }
}