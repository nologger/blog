package kim.board.repository;

import kim.board.model.Category;
import kim.board.model.Post;
import kim.board.model.dto.PostDTO;

import java.util.List;

public interface BoardRepository {
    public List<Post> selectPostsByCategory(Category category, int page);
    public Category selectCategoryByCategoryId(long categoryId);
    public Post selectPostByPostId(long postId);
    public void insertPost(PostDTO postDTO);
    public List<Category> selectCategoriesForGuest();
    public List<Category> selectCategoriesForAdmin();
    public List<Post> selectRecentlyPosts(int num);
    public int selectLastPage(long categoryId);
}
