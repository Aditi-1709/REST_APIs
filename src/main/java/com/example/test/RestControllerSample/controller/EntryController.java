//package com.example.test.RestControllerSample.controller;
//
//import com.example.test.RestControllerSample.entity.Entry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/_journal")
//public class EntryController {
//
//    private Map<Long, Entry> entries = new HashMap<>();
//
//    @GetMapping
//    public List<Entry> getAll() {
//        return new ArrayList<>(entries.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody Entry myEntry) {
//
//        entries.put(myEntry.getId(), myEntry);
//        return true;
//    }
//
//    @GetMapping("id/{myId}")
//    public Entry getEntryById(@PathVariable long myId) {
//        return entries.get(myId);
//    }
//
//    @DeleteMapping("id/{myId}")
//    public Entry deleteEntryById(@PathVariable long myId) {
//        return entries.remove(myId);
//    }
//
//    @PutMapping("/id/{id}")
//    public Entry updateEntryById(@PathVariable long id, @RequestBody Entry myEntry) {
//        return entries.put(id, myEntry);
//    }
//}
