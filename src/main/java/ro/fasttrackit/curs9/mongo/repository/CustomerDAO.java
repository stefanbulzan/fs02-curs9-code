package ro.fasttrackit.curs9.mongo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.curs9.mongo.model.CustomerEntity;
import ro.fasttrackit.curs9.mongo.model.CustomerFilters;

import java.util.List;

import static java.util.Optional.ofNullable;
import static org.springframework.data.support.PageableExecutionUtils.getPage;

@Repository
@RequiredArgsConstructor
public class CustomerDAO {
    private final MongoTemplate mongo;

    public Page<CustomerEntity> findBy(CustomerFilters filters, Pageable pageable) {
        Criteria criteria = new Criteria();
        ofNullable(filters.name())
                .ifPresent(name -> criteria.and("name").is(name));
        ofNullable(filters.age())
                .ifPresent(age -> criteria.and("age").gte(age));
        Query query = Query.query(criteria).with(pageable);
        List<CustomerEntity> content = mongo.find(query, CustomerEntity.class);
        return getPage(content, pageable,
                () -> mongo.count(Query.query(criteria), CustomerEntity.class));
    }
}
