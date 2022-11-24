package kim.blog.common.category.service.impl;

import kim.blog.common.category.repository.CategoryRepository;
import kim.blog.common.category.service.CategoryService;
import kim.blog.common.category.vo.CategoryVO;
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
    public List<CategoryVO> getAdminCategories() { return categoryRepository.selectAdminCategories(); }

    @Override
    public List<CategoryVO> getPostCategories() {
        return categoryRepository.selectPostCategories();
    }
}
