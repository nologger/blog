package kim.blog.home.board.controller;

import kim.blog.home.board.domain.PostDTO;
import kim.blog.home.board.service.BoardService;
import kim.blog.home.board.domain.PostVO;
import kim.blog.home.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/board")
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

    @GetMapping("/posting")
    public String posting(HttpSession session) {
        /* 권한검증  */
        Member member = (Member)session.getAttribute("member");
        if (member == null || !member.getAuthority().equals("admin")) {
            return "redirect:/";
        }

        return "home/board/posting";
    }

    @PostMapping("/posting")
    public String postingProcess(PostDTO postDTO, HttpSession session) {
        Member member = (Member)session.getAttribute("member");
        if (member == null || !member.getAuthority().equals("admin")) {
            return "redirect:/home";
        }

        postDTO.setWriter(member.getAccount());
        boardService.insertPost(postDTO);
        return "redirect:/board";
    }
}
