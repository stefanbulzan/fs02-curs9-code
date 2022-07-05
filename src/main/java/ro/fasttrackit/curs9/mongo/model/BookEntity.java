package ro.fasttrackit.curs9.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("books")
public record BookEntity(
        @Id
        String id,
        String name,
        List<String> customerId
) {
}
