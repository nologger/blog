package kim.blog.home.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/board")
public class BoardController {
    @GetMapping
    public String board() {
        return "/home/board";
    }
}
