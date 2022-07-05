package ro.fasttrackit.curs9.mongo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs9.mongo.model.CustomerEntity;
import ro.fasttrackit.curs9.mongo.model.CustomerFilters;
import ro.fasttrackit.curs9.mongo.repository.CustomerDAO;
import ro.fasttrackit.curs9.mongo.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerDAO dao;

    public Page<CustomerEntity> getAll(CustomerFilters filters, Pageable pageable) {
//        return repository.findAllByNameAndAge(filters.name(), filters.age(), pageable);
        return dao.findBy(filters, pageable);
    }
}
