package myblogapp.services.impl;

import myblogapp.entity.Category;
import myblogapp.exceptions.ResourceNotFoundException;
import myblogapp.payloads.CategoryDto;
import myblogapp.repository.CategoryRepository;
import myblogapp.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);

        Category newCategory = this.categoryRepo.save(category);

        return this.modelMapper.map(newCategory, CategoryDto.class);

    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        Category newCategory = categoryRepo.save(category);

        return this.modelMapper.map(category, CategoryDto.class);

    }

    @Override
    public void deleteCategory(long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        this.categoryRepo.delete(category);
    }

    @Override
    public CategoryDto getCategory(long categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        return this.modelMapper.map(category, CategoryDto.class);

    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> allCategories = categoryRepo.findAll();

        List<CategoryDto> dtos = allCategories.stream().map((category) -> modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
        return dtos;
    }


}
