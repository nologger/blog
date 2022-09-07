package kim.board.service.impl;

import kim.board.model.Category;
import kim.board.model.Post;
import kim.board.model.dto.PostDTO;
import kim.board.repository.BoardRepository;
import kim.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    BoardRepository boardRepository;
    final List<Category> categoriesForGuest;
    final List<Category> categoriesForAdmin;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
        categoriesForGuest = boardRepository.selectCategoriesForGuest();
        categoriesForAdmin = boardRepository.selectCategoriesForAdmin();
    }

    @Override
    public List<Category> getCategoriesForGuest() {
        return this.categoriesForGuest;
    }

    @Override
    public List<Category> getCategoriesForAdmin() { return this.categoriesForAdmin; }

    @Override
    public List<Post> selectPostsByCategory(Category category, int page) {
        return boardRepository.selectPostsByCategory(category, page);
    }

    @Override
    public Category selectCategoryByCategoryId(long categoryId) {
        return boardRepository.selectCategoryByCategoryId(categoryId);
    }

    @Override
    public Post selectPostByPostId(long postId) {
        return boardRepository.selectPostByPostId(postId);
    }

    @Override
    public void insertPost(PostDTO postDTO) {
        boardRepository.insertPost(postDTO);
        return;
    }

    @Override
    public List<Post> selectRecentlyPosts() {
        return boardRepository.selectRecentlyPosts(5);
    }

    @Override
    public int selectLastPage(long categoryId) {
        return boardRepository.selectLastPage(categoryId);
    }
}
