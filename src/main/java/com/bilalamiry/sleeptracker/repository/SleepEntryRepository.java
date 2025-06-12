package com.bilalamiry.sleeptracker.repository;

import com.bilalamiry.sleeptracker.model.SleepEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SleepEntryRepository extends JpaRepository<SleepEntry, Long> {
    //  CRUD is inherited
}
