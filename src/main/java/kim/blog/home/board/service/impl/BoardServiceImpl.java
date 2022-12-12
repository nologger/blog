package kim.blog.home.board.service.impl;

import kim.blog.home.board.domain.PostVO;
import kim.blog.home.board.repository.BoardRepository;
import kim.blog.home.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardRepository boardRepository;

    @Override
    public List<String> getAllPart() {
        return null;
    }

    @Override
    public List<PostVO> getPosts() {
        return boardRepository.getPosts();
    }

    @Override
    public PostVO getPost(long sequence) {
        return boardRepository.getPost(sequence);
    }

}
