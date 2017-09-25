package com.solaredge.spring5webapp.repositories;

import com.solaredge.spring5webapp.model.Book;
import com.solaredge.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
