package ro.fasttrackit.curs9.mongo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.curs9.mongo.model.CustomerEntity;
import ro.fasttrackit.curs9.mongo.model.CustomerFilters;
import ro.fasttrackit.curs9.mongo.service.CustomerService;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @GetMapping
    Page<CustomerEntity> getAll(CustomerFilters filters, Pageable pageable) {
        return service.getAll(filters, pageable);
    }
}
