package biblioexp.bibleo.Controller;

import biblioexp.bibleo.Entity.Category;
import biblioexp.bibleo.Service.CategoryService;




import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Categories")
public class CategoryController {
    private CategoryService CategoryService;
    public CategoryController(CategoryService categoryService) {
        super();
        this.CategoryService = categoryService;
    }
    // build create Category REST API
    @PostMapping()
    public ResponseEntity<Category> saveCategory(@RequestBody Category Category){
        return new
                ResponseEntity<Category>(CategoryService.saveCategory(Category),
                HttpStatus.CREATED);
    }
    // build get all Categorys REST API
    @GetMapping
    public List<Category> getAllCategories(){
        return CategoryService.getAllCategories();
    }
    // build get Category by id REST API
// http://localhost:8080/api/Categorys/1
    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id")
                                                    long CategoryId){
        return new
                ResponseEntity<Category>(CategoryService.getCategoryById(CategoryId),
                HttpStatus.OK);
    }
    // build update Category REST API
// http://localhost:8080/api/Categorys/1
    @PutMapping("{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id")
                                                   long id
            ,@RequestBody Category Category){
        return new
                ResponseEntity<Category>(CategoryService.updateCategory(Category, id),
                HttpStatus.OK);
    }
    // build delete Category REST API
// http://localhost:8080/api/Categorys/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") long
                                                         id){
// delete Category from DB
        CategoryService.deleteCategory(id);
        return new ResponseEntity<String>("Category deleted successfully!.", HttpStatus.OK);
    }
}
