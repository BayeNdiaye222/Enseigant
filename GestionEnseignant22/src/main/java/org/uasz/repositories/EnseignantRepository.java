package org.uasz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uasz.entities.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
}
