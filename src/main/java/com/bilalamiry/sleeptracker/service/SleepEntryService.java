package com.bilalamiry.sleeptracker.service;

import com.bilalamiry.sleeptracker.model.SleepEntry;

import java.util.List;

public interface SleepEntryService {
    List<SleepEntry> findAll();
    SleepEntry findById(Long id);
    SleepEntry save(SleepEntry entry);
    void deleteById(Long id);
}
