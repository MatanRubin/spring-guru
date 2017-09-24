package com.solaredge.spring5webapp.bootstrap;

import com.solaredge.spring5webapp.model.Author;
import com.solaredge.spring5webapp.model.Book;
import com.solaredge.spring5webapp.repositories.AuthorRepository;
import com.solaredge.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author orwell = new Author("George", "Orwell");
        Book nineteen84 = new Book("1984", "1111", "Penguin Books");
        orwell.getBooks().add(nineteen84);
        nineteen84.getAuthors().add(orwell);
        authorRepository.save(orwell);
        bookRepository.save(nineteen84);

        Author asimov = new Author("Isaac", "Asimov");
        Book foundation = new Book("Foundation", "2222", "Penguin Books");
        asimov.getBooks().add(foundation);
        foundation.getAuthors().add(asimov);
        authorRepository.save(asimov);
        bookRepository.save(foundation);
    }
}
