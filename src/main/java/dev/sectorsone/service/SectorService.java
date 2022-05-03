package dev.sectorsone.service;

import dev.sectorsone.model.Sector;
import dev.sectorsone.repositories.SectorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SectorService {

    private final SectorRepository repository;

    public List<Sector> findAll() {
        log.debug("Find all sectors");
        var result = repository.findAll();
        return result;
    }
}
