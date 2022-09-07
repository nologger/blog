package kim.main.controller;

import kim.board.model.Post;
import kim.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    BoardService boardService;

    @GetMapping("/")
    public String moveMain(Model model) {
        List<Post> posts = boardService.selectRecentlyPosts();
        model.addAttribute("posts", posts);

        return "index";
    }
}
