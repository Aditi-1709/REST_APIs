//package com.example.test.RestControllerSample;
//
//import com.mongodb.ConnectionString;
//import com.mongodb.MongoClientSettings;
//import com.mongodb.MongoException;
//import com.mongodb.ServerApi;
//import com.mongodb.ServerApiVersion;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
//import org.bson.Document;
//
//public class MongoDBConnectionTest {
//    public static void main(String[] args) {
//        // 🔹 Replace <ENCODED_PASSWORD> with your actual encoded password
//        String connectionString = "mongodb+srv://admin:DvaZ%40VBx3Zd9WXj@restapi.bpe2s.mongodb.net/journaldb?retryWrites=true&w=majority";
//
//        ServerApi serverApi = ServerApi.builder()
//                .version(ServerApiVersion.V1)
//                .build();
//
//        MongoClientSettings settings = MongoClientSettings.builder()
//                .applyConnectionString(new ConnectionString(connectionString))
//                .serverApi(serverApi)
//                .build();
//
//        // Create a new client and connect to the server
//        try (MongoClient mongoClient = MongoClients.create(settings)) {
//            try {
//                // Send a ping to confirm a successful connection
//                MongoDatabase database = mongoClient.getDatabase("journaldb"); // Change to your DB name
//                database.runCommand(new Document("ping", 1));
//                System.out.println("✅ Connected to MongoDB successfully!");
//            } catch (MongoException e) {
//                System.err.println("❌ Connection failed: " + e.getMessage());
//            }
//        }
//    }
//}

package com.example.test.RestControllerSample;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;

import org.bson.Document;

public class MongoDBConnectionTest {
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://admin:DvaZ%40VBx3Zd9WXj@RestAPI.bpe2s.mongodb.net/journaldb?retryWrites=true&w=majority&appName=RestAPI";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase("journaldb");
            MongoCollection<Document> collection = database.getCollection("entries"); // Replace with your actual collection name

            // Fetch all documents
            FindIterable<Document> documents = collection.find();
            System.out.println("📌 Retrieved Data from MongoDB:");
            for (Document doc : documents) {
                System.out.println(doc.toJson());
            }
        } catch (MongoException e) {
            System.err.println("❌ Operation failed: " + e.getMessage());
        }
    }
}





////package com.example.test.RestControllerSample;
////
////import com.mongodb.ConnectionString;
////import com.mongodb.MongoClientSettings;
////import com.mongodb.MongoException;
////import com.mongodb.ServerApi;
////import com.mongodb.ServerApiVersion;
////import com.mongodb.client.MongoClient;
////import com.mongodb.client.MongoClients;
////import com.mongodb.client.MongoDatabase;
////import org.bson.Document;
////
////public class MongoDBConnectionTest {
////    public static void main(String[] args) {
////        // 🔹 Replace <ENCODED_PASSWORD> with your actual encoded password
////        String connectionString = "mongodb+srv://admin:DvaZ%40VBx3Zd9WXj@restapi.bpe2s.mongodb.net/journaldb?retryWrites=true&w=majority";
////
////        ServerApi serverApi = ServerApi.builder()
////                .version(ServerApiVersion.V1)
////                .build();
////
////        MongoClientSettings settings = MongoClientSettings.builder()
////                .applyConnectionString(new ConnectionString(connectionString))
////                .serverApi(serverApi)
////                .build();
////
////        // Create a new client and connect to the server
////        try (MongoClient mongoClient = MongoClients.create(settings)) {
////            try {
////                // Send a ping to confirm a successful connection
////                MongoDatabase database = mongoClient.getDatabase("journaldb"); // Change to your DB name
////                database.runCommand(new Document("ping", 1));
////                System.out.println("✅ Connected to MongoDB successfully!");
////            } catch (MongoException e) {
////                System.err.println("❌ Connection failed: " + e.getMessage());
////            }
////        }
////    }
////}
//
//package com.example.test.RestControllerSample;
//
//import com.mongodb.ConnectionString;
//import com.mongodb.MongoClientSettings;
//import com.mongodb.MongoException;
//import com.mongodb.ServerApi;
//import com.mongodb.ServerApiVersion;
//import com.mongodb.client.*;
//
//import org.bson.Document;
//
//public class MongoDBConnectionTest {
//    public static void main(String[] args) {
//        String connectionString = "mongodb+srv://admin:DvaZ%40VBx3Zd9WXj@RestAPI.bpe2s.mongodb.net/journaldb?retryWrites=true&w=majority&appName=RestAPI";
//
//        ServerApi serverApi = ServerApi.builder()
//                .version(ServerApiVersion.V1)
//                .build();
//
//        MongoClientSettings settings = MongoClientSettings.builder()
//                .applyConnectionString(new ConnectionString(connectionString))
//                .serverApi(serverApi)
//                .build();
//
//        try (MongoClient mongoClient = MongoClients.create(settings)) {
//            MongoDatabase database = mongoClient.getDatabase("journaldb");
//            MongoCollection<Document> collection = database.getCollection("entries"); // Replace with your actual collection name
//
//            // Fetch all documents
//            FindIterable<Document> documents = collection.find();
//            System.out.println("📌 Retrieved Data from MongoDB:");
//            for (Document doc : documents) {
//                System.out.println(doc.toJson());
//            }
//        } catch (MongoException e) {
//            System.err.println("❌ Operation failed: " + e.getMessage());
//        }
//    }
//}
//
