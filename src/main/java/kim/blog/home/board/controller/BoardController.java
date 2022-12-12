package kim.blog.home.board.controller;

import kim.blog.home.board.domain.PostVO;
import kim.blog.home.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/home/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping
    public String board(Model model) {
        List<PostVO> postVOList = boardService.getPosts();
        model.addAttribute("posts", postVOList);
        return "home/board";
    }

    @GetMapping("/view")
    public String view(long sequence, Model model) {
        PostVO postVO = boardService.getPost(sequence);
        model.addAttribute("post", postVO);
        return "home/board/view";
    }
}
