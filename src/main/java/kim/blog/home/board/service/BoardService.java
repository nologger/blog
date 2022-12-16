package kim.blog.home.board.service;

import kim.blog.home.board.domain.PostDTO;
import kim.blog.home.board.domain.PostVO;

import java.util.List;

public interface BoardService {
    List<String> getAllPart();
    List<PostVO> getPosts();
    PostVO getPost(long sequence);
    void insertPost(PostDTO postDTO);
    String validatePost(String content);
}
