package ru.lightvsi.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lightvsi.urlshortener.entity.URLPair;

import java.util.Optional;

@Repository
public interface URLPairRepository extends JpaRepository<URLPair, Long> {
    Optional<URLPair> findByLurl(String string);

    Optional<URLPair> findBySurl(String string);

    boolean existsByLurl(String string);

    boolean existsBySurl(String string);
}
