package biblioexp.bibleo.Controller;

import biblioexp.bibleo.Entity.Book;
import biblioexp.bibleo.Entity.Category;
import biblioexp.bibleo.Entity.Loan;
import biblioexp.bibleo.Entity.User;
import biblioexp.bibleo.Service.BookService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import biblioexp.bibleo.config.CustomLoginSucessHandler;


import biblioexp.bibleo.Service.CategoryService;
import biblioexp.bibleo.Service.LoanService;
import biblioexp.bibleo.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/Books")
public class BookController {
    private final BookService BookService;
    private final UserService UserService;
    private final LoanService LoanService;
    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    public BookController(BookService bookService, biblioexp.bibleo.Service.UserService userService, biblioexp.bibleo.Service.LoanService loanService) {
        this.BookService = bookService;
        this.UserService = userService;
        this.LoanService = loanService;
    }
    @Autowired
    private CategoryService categoryService;
    // build create Book REST API
    @PostMapping()
    public ResponseEntity<Book> saveBook(@RequestBody Book Book) {
        return new
                ResponseEntity<Book>(BookService.saveBook(Book),
                HttpStatus.CREATED);
    }

    // build get all Books REST API
    @GetMapping
    public List<Book> getAllBooks() {
        return BookService.getAllBooks();
    }

    // build get Book by id REST API
// http://localhost:8080/api/Books/1
    @GetMapping("{ISBN}")
    public ResponseEntity<Book> getBookById(@PathVariable("ISBN")
                                            long ISBN) {
        return new
                ResponseEntity<Book>(BookService.getBookById(ISBN),
                HttpStatus.OK);
    }
    @GetMapping("/edit/{ISBN}")
    public ModelAndView showUpdateForm(@PathVariable("ISBN") Long ISBN)  {
        Book book = BookService.getBookById(ISBN);
        List<Category> categories = categoryService.getAllCategories();

        ModelAndView modelAndView = new ModelAndView("update-book");
        modelAndView.addObject("book", book);
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }






    @PostMapping("/update/{ISBN}")
    public ModelAndView updateBook(@PathVariable("ISBN") long ISBN,
                                   @Valid @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Book book,
                                   BindingResult result, Model model) {
        if (result.hasErrors()) {
            book.setISBN(ISBN);
            // Log validation errors
            logger.error("Validation errors occurred for ISBN {}: {}", ISBN, result.getAllErrors());

            // Handle validation errors as needed
            return new ModelAndView("redirect:/api/Books/edit/{ISBN}");
        }

        try {
            Book updatedBook = BookService.updateBook(book, ISBN);
            logger.info("Book updated successfully. ISBN: {}", updatedBook.getISBN());
        } catch (Exception e) {
            logger.error("Error updating book with ISBN " + ISBN, e);
            // Handle the exception as needed
        }

        return new ModelAndView("redirect:/api/Books/BookList");
    }
    // Delete User REST API
    // http://localhost:8080/api/users/1
    @GetMapping("/delete/{ISBN}")
    public ModelAndView deleteBook(@PathVariable("ISBN") long ISBN, Model model) {
        BookService.deleteBook(ISBN);
        return new ModelAndView("redirect:/api/Books/BookList");
    }

    @GetMapping("/BookList")
    public ModelAndView showBookList() {
        List<Book> BookList = BookService.getAllBooks();
        ModelAndView modelAndView = new ModelAndView("booklist");
        modelAndView.addObject("BookList", BookList);
        return modelAndView;

    }

    @PostMapping("/loan/{isbn}")
    public ResponseEntity<String> loanBook(@PathVariable("isbn") Long isbn, HttpServletRequest request) {
        // Get the user ID from the cookie
        Long userIdFromCookie = CustomLoginSucessHandler.getUserIDFromCookie(request);

        // Retrieve the book and user based on their IDs
        Book book = BookService.getBookById(isbn);
        User user = UserService.getUserById(userIdFromCookie);

        // Check if the book is available for loan
        if (book.getAvb_copies() > 0) {
            // Perform the loan
            Loan loan = new Loan(book, user, new Date(), calculateReturnDate());
            LoanService.saveLoan(loan);

            // Update the available copies of the book
            book.setAvb_copies(book.getAvb_copies() - 1);
            BookService.saveBook(book);

            return new ResponseEntity<>("Book loaned successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book not available for loan.", HttpStatus.BAD_REQUEST);
        }
    }

    // Helper method to calculate the return date (10 days from the borrow date)
    private Date calculateReturnDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 10);
        return calendar.getTime();
    }


}