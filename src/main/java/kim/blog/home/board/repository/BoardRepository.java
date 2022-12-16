package kim.blog.home.board.repository;

import kim.blog.home.board.domain.PostDTO;
import kim.blog.home.board.domain.PostVO;

import java.util.List;

public interface BoardRepository {
    List<String> getAllPart();
    List<PostVO> getPosts();
    PostVO getPost(long sequence);
    List<PostVO> getPosts(String part);
    void insertPost(PostDTO postDTO);
}
