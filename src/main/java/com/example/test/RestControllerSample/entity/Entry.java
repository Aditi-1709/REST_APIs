package com.example.test.RestControllerSample.entity;

import java.time.LocalDateTime;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.web.bind.annotation.RestController;

@Document(collection = "entries")
public class Entry
{
    @Id
    private ObjectId id;

    private String title;

    private String content;

    private LocalDateTime date;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

//{
//
//        "id": 3,
//        "title": "Evening",
//        "content": "Good Evening to all!"
//
//        }

//{
//
//        "id": 2,
//        "title": "Afternoon",
//        "content": "Good Afternoon to all!"
//
//}

//{
//        "id": 1,
//        "title": "Morning",
//        "content": "Good Morning to all!"
//        }



