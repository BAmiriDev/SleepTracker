package com.bilalamiry.sleeptracker.service;

import com.bilalamiry.sleeptracker.model.SleepEntry;
import com.bilalamiry.sleeptracker.repository.SleepEntryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SleepEntryServiceTest {

    private SleepEntryRepository repo;
    private com.bilalamiry.sleeptracker.service.impl.SleepEntryServiceImpl service;

    @BeforeEach
    void setup() {
        repo = mock(SleepEntryRepository.class);
        service = new com.bilalamiry.sleeptracker.service.impl.SleepEntryServiceImpl(repo);
    }

    @Test
    void testSave() {
        SleepEntry entry = new SleepEntry();
        entry.setDate(LocalDate.now());
        entry.setSleepTime(LocalTime.of(22, 0));
        entry.setWakeTime(LocalTime.of(6, 0));
        entry.setQuality("Good");

        when(repo.save(entry)).thenReturn(entry);

        assertEquals(entry, service.save(entry));
    }

//    @Test
//    void testFindById() {
//        SleepEntry entry = new SleepEntry();
//        entry.setId(1L);
//        when(repo.findById(1L)).thenReturn(Optional.of(entry));
//
//        assertTrue(service.findById(1L).isPresent());
//        assertEquals(1L, service.findById(1L).get().getId());
//    }

    @Test
    void testDelete() {
        service.deleteById(5L);
        verify(repo).deleteById(5L);
    }
}
