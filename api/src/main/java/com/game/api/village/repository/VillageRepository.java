package com.game.api.village.repository;


import com.game.api.village.entity.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VillageRepository extends JpaRepository<Village,Long> {
    Optional<Village> findByName(String name);


    int countByName(String username);
}
