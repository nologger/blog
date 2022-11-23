package kim.blog.category.repository;

import kim.blog.category.vo.CategoryVO;

import java.util.List;

public interface CategoryRepository {
    public List<CategoryVO> selectMainCategories();
    public List<CategoryVO> selectAdminCategories();
    public List<CategoryVO> selectPostCategories();
}
