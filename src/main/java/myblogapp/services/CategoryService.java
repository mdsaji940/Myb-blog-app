package myblogapp.services;

import myblogapp.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, long categoryId);

    public void deleteCategory(long categoryId);

    CategoryDto getCategory(long categoryId);

    List<CategoryDto> getCategories();
}
