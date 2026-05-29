package monsite.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import monsite.model.Book;
import monsite.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    //Constructeur 
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    //Méthodes 
    //Lister tous les livres 
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    //trouver un livre par Id 
    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    //Sauvegarder ou modifier un livre 
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    //Supprimer un livre 
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    } 
}
