package kim.blog.common.category.service;

import kim.blog.common.category.vo.CategoryVO;

import java.util.List;

public interface CategoryService {
    public List<CategoryVO> getMainCategories();
    public List<CategoryVO> getAdminCategories();
    public List<CategoryVO> getPostCategories();
}
