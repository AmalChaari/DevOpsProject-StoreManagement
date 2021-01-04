 package tn.iit.controller;

import org.springframework.web.bind.annotation.*;
import tn.iit.dto.CategoryDto;
import tn.iit.service.CategoryService;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin("*")
@RequestMapping(value = "/categories")
@RestController()
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("{id}")
    public CategoryDto findOne(@PathVariable("id") long id) {
        return this.categoryService.findOne (id);
    }

    @GetMapping
    public Collection<CategoryDto> findAll(){
        return this.categoryService.findAll ();
    }

    @PostMapping
    public CategoryDto add(@Valid @RequestBody CategoryDto categoryDto){
        return this.categoryService.save (categoryDto);
    }

    @PutMapping
    public CategoryDto update(@Valid @RequestBody CategoryDto categoryDto){
         return this.categoryService.save (categoryDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        this.categoryService.deleteById (id);
    }

}
