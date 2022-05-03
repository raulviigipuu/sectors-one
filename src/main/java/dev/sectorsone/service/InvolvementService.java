package dev.sectorsone.service;

import dev.sectorsone.model.Involvement;
import dev.sectorsone.repositories.InvolvementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class InvolvementService {

    private final InvolvementRepository repository;

    public List<Involvement> findAll() {
        log.debug("Find all involvements.");
        return repository.findAll();
    }

    public Optional<Involvement> findById(Long id) {
        log.debug("Find involvement by id: {}", id);
        var result = repository.findById(id);
        if (result.isEmpty()) {
            log.error("Involvement with id {} not found!", id);
        }
        return result;
    }

    public Involvement save(Involvement involvement) {
        log.debug("Save involvement");
        return repository.save(involvement);
    }

    /**
     * Delete involvement
     *
     * @param id - involvement id
     * @return true if involvement exists and was deleted, false otherwise
     */
    public boolean deleteById(Long id) {
        log.debug("Delete involvement with id: {}", id);
        var involvement = repository.findById(id);
        if (involvement.isPresent()) {
            repository.delete(involvement.get());
            return true;
        }
        log.warn("Involvement with id {} not found!", id);
        return false;
    }
}
