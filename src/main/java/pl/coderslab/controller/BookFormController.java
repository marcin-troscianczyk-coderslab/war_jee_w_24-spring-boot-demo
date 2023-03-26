package pl.coderslab.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.CategoryService;
import pl.coderslab.service.PublisherService;

import java.util.List;

@Controller
@RequiredArgsConstructor
class BookFormController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @GetMapping(path = "/book/form")
    String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping(path = "/book/form")
    String processAddBookForm(@Valid Book book, BindingResult errors) {

        if (errors.hasErrors()) {
            return "book/add";
        }

        bookService.save(book);

        return "redirect:/book/list";
    }

    @GetMapping(path = "/book/edit")
    String showEditBookForm(@RequestParam Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "book/edit";
    }

    @PostMapping(path = "/book/edit")
    String processEditBookForm(@Valid Book book, BindingResult errors) {

        if (errors.hasErrors()) {
            return "book/edit";
        }

        bookService.update(book);

        return "redirect:/book/list";
    }

    @GetMapping(path = "/book/list")
    String showBookList(Model model) {

        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);

        return "book/list";
    }

    // np. http://localhost:8080/book/search?title=Java+techniki+programowania
    @GetMapping(path = "/book/search", params = "title")
    String findByTile(@RequestParam String title, Model model) {

        List<Book> books = bookService.findByTitle(title);
        model.addAttribute("books", books);

        return "book/list";

    }

    // np. http://localhost:8080/book/search?id=2
    @GetMapping(path = "/book/search", params = "id")
    String findByCategory(Category category, Model model) {

        List<Book> books = bookService.findByCategory(category);
        model.addAttribute("books", books);

        return "book/list";
    }

    // np. http://localhost:8080/book/search?categoryId=2
    @GetMapping(path = "/book/search", params = "categoryId")
    String findByCategoryId(@RequestParam Long categoryId, Model model) {

        List<Book> books = bookService.findByCategoryId(categoryId);
        model.addAttribute("books", books);

        return "book/list";
    }

    @ModelAttribute("publishers")
    List<Publisher> publishers() {
        return publisherService.findAll();
    }

    @ModelAttribute("authors")
    List<Author> authors() {
        return authorService.findAll();
    }

    @ModelAttribute("categories")
    List<Category> categories() {
        return categoryService.findAll();
    }

}
