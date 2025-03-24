package com.example.test.RestControllerSample.service;

import com.example.test.RestControllerSample.entity.Entry;
import com.example.test.RestControllerSample.repository.EntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.support.PageableExecutionUtils;

import org.springframework.data.domain.Pageable;

@Component
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;


    public void saveEntry(Entry entry){
        entryRepository.save(entry);

    }

    public List<Entry> getAll(){
        return entryRepository.findAll();
    }

    public Optional<Entry> findById(ObjectId id){
        return entryRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        entryRepository.deleteById(id);
    }

    public Page<Entry> getEntriesWithPagination(Pageable pageable) {
        return entryRepository.findAll(pageable);
    }
}
