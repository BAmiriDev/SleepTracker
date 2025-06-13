package com.bilalamiry.sleeptracker.repository;

import com.bilalamiry.sleeptracker.model.SleepEntry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class SleepEntryRepositoryTest {

    @Autowired
    private SleepEntryRepository repository;

    @Test
    void testSaveAndFindById() {
        SleepEntry entry = new SleepEntry();
        entry.setDate(LocalDate.now());
        entry.setSleepTime(LocalTime.of(23, 0));
        entry.setWakeTime(LocalTime.of(7, 0));
        entry.setQuality("Good");
        entry.setNotes("Test note");

        SleepEntry saved = repository.save(entry);
        assertThat(repository.findById(saved.getId())).isPresent();
    }

    @Test
    void testDeleteById() {
        SleepEntry entry = new SleepEntry();
        entry.setDate(LocalDate.now());
        entry.setSleepTime(LocalTime.of(23, 0));
        entry.setWakeTime(LocalTime.of(7, 0));
        entry.setQuality("Good");
        entry.setNotes("To delete");

        SleepEntry saved = repository.save(entry);
        repository.deleteById(saved.getId());

        assertThat(repository.findById(saved.getId())).isNotPresent();
    }

    @Test
    void testFindAll() {
        SleepEntry entry1 = new SleepEntry();
        entry1.setDate(LocalDate.now().minusDays(1));
        entry1.setSleepTime(LocalTime.of(22, 0));
        entry1.setWakeTime(LocalTime.of(6, 0));
        entry1.setQuality("Okay");

        SleepEntry entry2 = new SleepEntry();
        entry2.setDate(LocalDate.now());
        entry2.setSleepTime(LocalTime.of(23, 0));
        entry2.setWakeTime(LocalTime.of(7, 0));
        entry2.setQuality("Good");

        repository.save(entry1);
        repository.save(entry2);

        assertThat(repository.findAll()).hasSizeGreaterThanOrEqualTo(2);
    }
}
