package br.com.movieflix.Controller;

import br.com.movieflix.Controller.request.CategoryRequest;
import br.com.movieflix.Controller.response.CategoryResponse;
import br.com.movieflix.entity.Category;
import br.com.movieflix.mapper.CategoryMapper;
import br.com.movieflix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public List<CategoryResponse> getAllCategories(){
        List<Category> categories = categoryService.findAll();
        return categories.stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();
    }

    // pede um request - transforma esse request em um objeto -
    // Salva esse objeto no banco de dados - transforma o objeto em resposta
    // e manda de volta para o usuario
    @PostMapping()
    public CategoryResponse saveCategory(@RequestBody CategoryRequest request){
        Category newCategory = CategoryMapper.toCategory(request);
        Category saveCategory = categoryService.saveCategory(newCategory);
        return CategoryMapper.toCategoryResponse(newCategory);
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryId(@PathVariable Long id){
        Optional<Category> optCategory = categoryService.findById(id);
        if(optCategory.isPresent()){
          CategoryResponse category = CategoryMapper.toCategoryResponse(optCategory.get());
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategoryById(@PathVariable Long id){
        categoryService.deleteById(id);
    }



}
