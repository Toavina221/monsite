package monsite.controller;

import monsite.model.Book;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import monsite.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    //Page qui liste tous les livres 
    @GetMapping
    public String listBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        model.addAttribute("titre", "Liste des Livres");
        return "books/list";
    }

    //formulaire pour ajouter un livre 
    @GetMapping("/new")
    public String newBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("titre", "Ajouter un livre");
        return "books/new";
    }

    //Sauvegarder le livre 
    @PostMapping
    public String saveBook(@ModelAttribute Book book, Model model) {
        try {
            bookService.saveBook(book);
            return "redirect:/books";
        } catch (Exception e) {
            model.addAttribute("error", "Erreur lors de l'enregistrement : " + e.getMessage());
            model.addAttribute("book", book);
            return "books/new";
        }
    }
    
    //Modifier un livre (afficher la formulaire)
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        return bookService.getBookById(id)
        .map(book -> {
            model.addAttribute("book" , book);
            model.addAttribute("titre", "Modifier le livre ");
            return "books/edit";
        })
        .orElse("redirect:/books"); 
    }

// Sauvegarder les modifications
@PostMapping("/edit/{id}")
public String updateBook(@PathVariable Long id, @ModelAttribute Book book) {
    book.setId(id);
    bookService.saveBook(book);
    return "redirect:/books";
}

// Supprimer un livre
@GetMapping("/delete/{id}")
public String deleteBook(@PathVariable Long id) {
    bookService.deleteBook(id);
    return "redirect:/books";
}
    
    
    
}
