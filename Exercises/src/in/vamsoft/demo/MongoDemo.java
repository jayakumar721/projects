package in.vamsoft.demo;

import java.util.Arrays;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class MongoDemo {
  
  public static void main(String[] args) {
    try {
      @SuppressWarnings("resource")
     MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
      MongoClient mongoClient = new MongoClient(connectionString);
      @SuppressWarnings("deprecation")
      DB database = mongoClient.getDB("jkdb");
      
      database.getCollection("sample").find().forEach(System.out::println);
  
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
        
  }

}
