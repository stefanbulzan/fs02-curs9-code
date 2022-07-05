package ro.fasttrackit.curs9.mongo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.curs9.mongo.model.CustomerEntity;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
    Page<CustomerEntity> findAllByNameAndAge(String name, Integer age, Pageable pageable);
}
