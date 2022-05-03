package dev.sectorsone.repositories;

import dev.sectorsone.model.Involvement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvolvementRepository extends JpaRepository<Involvement, Long> {
}
