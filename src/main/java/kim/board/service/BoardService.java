package kim.board.service;

import kim.board.model.Category;
import kim.board.model.Post;
import kim.board.model.dto.PostDTO;

import java.util.List;

public interface BoardService {
    List<Category> getCategoriesForGuest();
    List<Category> getCategoriesForAdmin();
    public List<Post> selectPostsByCategory(Category category, int page);
    public Category selectCategoryByCategoryId(long categoryId);
    public Post selectPostByPostId(long postId);
    public void insertPost(PostDTO postDTO);
    public List<Post> selectRecentlyPosts();
    public int selectLastPage(long categoryId);
}
