package ru.fassakhova.mimimimetrv2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "cats")
public class Cat extends AbstractEntity{

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
        if (!getId().equals(cat.getId())) return false;
        if (!name.equals(cat.name)) return false;
        return imageUrl.equals(cat.imageUrl);
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + imageUrl.hashCode();
        result = 31 * result + votes;
        return result;
    }
}