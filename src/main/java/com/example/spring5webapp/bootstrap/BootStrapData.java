package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.domain.Author;
import com.example.spring5webapp.domain.Book;
import com.example.spring5webapp.domain.Publisher;
import com.example.spring5webapp.repositories.AuthorRepository;
import com.example.spring5webapp.repositories.BookRepository;
import com.example.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(PublisherRepository publisherRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Jones Publishing");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book booky = new Book("My booky", "123456");
        eric.getBooks().add(booky);
        booky.getAuthors().add(eric);
        booky.setPublisher(publisher);
        publisher.getBooks().add(booky);

        authorRepository.save(eric);
        bookRepository.save(booky);
        publisherRepository.save(publisher);

        Author bob = new Author("Bob", "Smith");
        Book springBook = new Book("Spring Book", "98765");
        bob.getBooks().add(springBook);
        springBook.getAuthors().add(bob);
        springBook.setPublisher(publisher);
        publisher.getBooks().add(springBook);

        authorRepository.save(bob);
        bookRepository.save(springBook);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher number of Books: " + publisher.getBooks().size());
    }
}
