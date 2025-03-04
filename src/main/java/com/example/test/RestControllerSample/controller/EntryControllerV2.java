package com.example.test.RestControllerSample.controller;

import com.example.test.RestControllerSample.entity.Entry;
import com.example.test.RestControllerSample.service.EntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;  // Change: Added import for pagination
import org.springframework.data.domain.PageRequest;  // Change: Added import for PageRequest
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/journal")
public class EntryControllerV2 {

    @Autowired
    private EntryService entryService;


    // CREATE
    @PostMapping
    public Entry createEntry(@RequestBody Entry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        entryService.saveEntry(myEntry);
        return myEntry;
    }

    // READ
    @GetMapping
    public List<Entry> getAll() {

        return entryService.getAll();
    }

    // Find by id
    @GetMapping("id/{myId}")
    public Entry getEntryById(@PathVariable ObjectId myId) {

        return entryService.findById(myId).orElse(null) ;
    }

    // Delete by id
    @DeleteMapping("id/{myId}")
    public boolean deleteEntryById(@PathVariable ObjectId myId) {

        entryService.deleteById(myId);
        return true;
    }

    // Update by id
    @PutMapping("/id/{id}")
    public Entry updateEntryById(@PathVariable ObjectId id, @RequestBody Entry newEntry) {

        Entry old = entryService.findById(id).orElse(null);
        if (old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.equals("") ? newEntry.getContent() : old.getContent());
        }
//        myEntry.setDate(LocalDateTime.now());
        entryService.saveEntry(old);
        return old;
    }

    @GetMapping("/paginated")
    public Page<Entry> getEntriesWithPagination(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return entryService.getEntriesWithPagination(page, size);
    }
}
