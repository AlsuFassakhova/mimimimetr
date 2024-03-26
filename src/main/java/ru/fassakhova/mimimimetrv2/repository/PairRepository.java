package ru.fassakhova.mimimimetrv2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fassakhova.mimimimetrv2.entity.Pair;

@Repository
public interface PairRepository extends JpaRepository<Pair, Long> {

}
