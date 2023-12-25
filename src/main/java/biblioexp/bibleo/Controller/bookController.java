package biblioexp.bibleo.Controller;

import biblioexp.bibleo.Entity.Book;

import biblioexp.bibleo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class bookController {
    /*
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return BookService.getAllBooks();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return BookService.saveBook(book);
    }

     */
}
