package kim.blog.category.service.impl;

import kim.blog.category.repository.CategoryRepository;
import kim.blog.category.service.CategoryService;
import kim.blog.category.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryVO> getMainCategories() {
        return categoryRepository.selectMainCategories();
    }

    @Override
    public List<CategoryVO> getPostCategories() {
        return categoryRepository.selectPostCategories();
    }
}
