package ro.fasttrackit.curs9.mongo.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "customers")
public record CustomerEntity(
        @Id
        String id,
        String name,
        int age,
        Address address
) {
}
