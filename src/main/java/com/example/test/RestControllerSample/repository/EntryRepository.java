package com.example.test.RestControllerSample.repository;

import com.example.test.RestControllerSample.entity.Entry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EntryRepository extends MongoRepository<Entry, ObjectId> {


    Page<Entry> findAll(Pageable pageable);
}
