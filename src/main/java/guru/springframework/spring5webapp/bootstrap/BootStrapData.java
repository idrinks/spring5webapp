package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Address;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AddressRepository;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AddressRepository addressRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {


        Publisher publisher = new Publisher("Apress");
        Address publisherAddress = new Address("3333 N Mattox Lane", "Pheonix", "Arizona", 80555);

        publisher.getAddresses().add(publisherAddress);
        publisherAddress.setPublisher(publisher);

        publisherRepository.save(publisher);
        addressRepository.save(publisherAddress);


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books:" + bookRepository.count());

        System.out.println("Number of Publishers:" + publisherRepository.count());

        System.out.println("Number of books per publisher:" + publisher.getBooks().size());


    }
}
