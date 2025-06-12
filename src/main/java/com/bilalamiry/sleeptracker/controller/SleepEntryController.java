package com.bilalamiry.sleeptracker.controller;

import com.bilalamiry.sleeptracker.model.SleepEntry;
import com.bilalamiry.sleeptracker.repository.SleepEntryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sleep")
public class SleepEntryController {

    private final SleepEntryRepository repository;

    public SleepEntryController(SleepEntryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listEntries(Model model) {
        model.addAttribute("entries", repository.findAll());
        return "sleep_list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("sleepEntry", new SleepEntry());
        return "sleep_form";
    }

    @PostMapping
    public String saveEntry(@ModelAttribute SleepEntry sleepEntry) {
        repository.save(sleepEntry);
        return "redirect:/sleep";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        SleepEntry entry = repository.findById(id).orElseThrow();
        model.addAttribute("sleepEntry", entry);
        return "sleep_form";
    }

    @PostMapping("/update/{id}")
    public String updateEntry(@PathVariable Long id, @ModelAttribute SleepEntry sleepEntry) {
        sleepEntry.setId(id);
        repository.save(sleepEntry);
        return "redirect:/sleep";
    }

    @GetMapping("/delete/{id}")
    public String deleteEntry(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/sleep";
    }
}
