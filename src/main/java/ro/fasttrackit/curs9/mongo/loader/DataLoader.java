package ro.fasttrackit.curs9.mongo.loader;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrackit.curs9.mongo.model.Address;
import ro.fasttrackit.curs9.mongo.model.CustomerEntity;
import ro.fasttrackit.curs9.mongo.repository.CustomerRepository;

import java.util.List;

import static java.util.UUID.randomUUID;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final CustomerRepository customerRepository;


    @Override
    public void run(String... args) throws Exception {
        List.of(
                new CustomerEntity(randomUUID().toString(), "Ana", 33, new Address("Unirii", "Bucuresti")),
                new CustomerEntity(randomUUID().toString(), "Ioan", 23, new Address("Kings Road", "London")),
                new CustomerEntity(randomUUID().toString(), "Maria", 64, new Address("Brancusi", "Oradea")),
                new CustomerEntity(randomUUID().toString(), "Mihai", 22, new Address("Victoriei", "Bucuresti"))
        ).forEach(customerRepository::save);

        System.out.println(customerRepository.findAll());
    }
}
