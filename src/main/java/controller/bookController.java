package controller;

import entity.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class bookController {
    @GetMapping("/book/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    // addbook

    //updatebook

    //deletebook

}
