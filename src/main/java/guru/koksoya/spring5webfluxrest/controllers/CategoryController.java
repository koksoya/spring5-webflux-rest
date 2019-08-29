package guru.koksoya.spring5webfluxrest.controllers;

import guru.koksoya.spring5webfluxrest.domain.Category;
import guru.koksoya.spring5webfluxrest.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository repository) {
        this.categoryRepository = repository;
    }

    @GetMapping("/api/v1/categories/")
    public Flux<Category> list() {
        return categoryRepository.findAll();
    }

    @GetMapping("/api/v1/categories/{id}")
    public Mono<Category> getById(@PathVariable String id) {
        return categoryRepository.findById(id);
    }
}
