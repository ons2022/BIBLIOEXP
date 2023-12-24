package biblioexp.bibleo.Controller;

import biblioexp.bibleo.Entity.book;

import biblioexp.bibleo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class bookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public book createBook(@RequestBody book book) {
        return bookService.saveBook(book);
    }
}
