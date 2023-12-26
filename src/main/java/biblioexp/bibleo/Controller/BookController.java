package biblioexp.bibleo.Controller;

import biblioexp.bibleo.Entity.Book;
import biblioexp.bibleo.Imp.BookServiceImp;
import biblioexp.bibleo.Service.BookService;




import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Books")
public class BookController {
    private final BookService BookService;  // Changed the variable name to follow camelCase
    public BookController(BookService bookService) {
        this.BookService = bookService;
    }
    // build create Book REST API
    @PostMapping()
    public ResponseEntity<Book> saveBook(@RequestBody Book Book){
        return new
                ResponseEntity<Book>(BookService.saveBook(Book),
                HttpStatus.CREATED);
    }
    // build get all Books REST API
    @GetMapping
    public List<Book> getAllBooks(){
        return BookService.getAllBooks();
    }
    // build get Book by id REST API
// http://localhost:8080/api/Books/1
    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id")
                                            long BookId){
        return new
                ResponseEntity<Book>(BookService.getBookById(BookId),
                HttpStatus.OK);
    }
    // build update Book REST API
// http://localhost:8080/api/Books/1
    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id")
                                           long id
            ,@RequestBody Book Book){
        return new
                ResponseEntity<Book>(BookService.updateBook(Book, id),
                HttpStatus.OK);
    }
    // build delete Book REST API
// http://localhost:8080/api/Books/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") long
                                                     id){
// delete Book from DB
        BookService.deleteBook(id);
        return new ResponseEntity<String>("Book deleted successfully!.", HttpStatus.OK);
    }



}
