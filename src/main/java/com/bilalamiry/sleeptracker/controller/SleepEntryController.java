package com.bilalamiry.sleeptracker.controller;

import com.bilalamiry.sleeptracker.model.SleepEntry;
import com.bilalamiry.sleeptracker.repository.SleepEntryRepository;
import com.bilalamiry.sleeptracker.service.SleepEntryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sleep")
public class SleepEntryController {

    private final SleepEntryService service;

    public SleepEntryController(SleepEntryService service) {
        this.service = service;
    }

    @GetMapping
    public String listEntries(Model model) {
        model.addAttribute("entries", service.findAll());
        return "sleep_list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("sleepEntry", new SleepEntry());
        return "sleep_form";
    }

    @PostMapping
    public String saveEntry(@ModelAttribute SleepEntry sleepEntry) {
        service.save(sleepEntry);
        return "redirect:/sleep";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("sleepEntry", service.findById(id));
        return "sleep_form";
    }

    @PostMapping("/update/{id}")
    public String updateEntry(@PathVariable Long id, @ModelAttribute SleepEntry sleepEntry) {
        sleepEntry.setId(id);
        service.save(sleepEntry);
        return "redirect:/sleep";
    }

    @GetMapping("/delete/{id}")
    public String deleteEntry(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/sleep";
    }
}
