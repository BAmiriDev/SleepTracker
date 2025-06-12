package com.bilalamiry.sleeptracker.service.impl;

import com.bilalamiry.sleeptracker.model.SleepEntry;
import com.bilalamiry.sleeptracker.repository.SleepEntryRepository;
import com.bilalamiry.sleeptracker.service.SleepEntryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SleepEntryServiceImpl implements SleepEntryService {

    private final SleepEntryRepository repository;

    public SleepEntryServiceImpl(SleepEntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SleepEntry> findAll() {
        return repository.findAll();
    }

    @Override
    public SleepEntry findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public SleepEntry save(SleepEntry entry) {
        return repository.save(entry);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
