package kim.board.controller;

import kim.board.model.Category;
import kim.board.model.Page;
import kim.board.model.Post;
import kim.board.model.dto.PostDTO;
import kim.board.service.BoardService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequestMapping("/board")
@Controller
@Slf4j
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping
    public String viewBoardByCategory(@RequestParam long categoryId, @RequestParam(required = false, defaultValue = "1") int page, Model model) {
        // Initialization
        int startPageRange = (page - 1) / 5 * 5 + 1;
        int endPageRange = (page - 1) / 5 * 5 + 5;
        int lastPage = boardService.selectLastPage(categoryId);
        String previous = startPageRange == 1 ? "disabled" : "";
        String next = endPageRange > lastPage ? "disabled" : "";
        List<Page> pages = IntStream.rangeClosed(startPageRange, endPageRange).mapToObj(p -> new Page(p, p > lastPage ? "disabled" : p == page ? "active" : "")).collect(Collectors.toList());
        Category category = boardService.selectCategoryByCategoryId(categoryId);
        List<Post> posts = boardService.selectPostsByCategory(category, page);
        String view = category.getViewPath();

        // Set Model
        model.addAttribute("previous", previous);
        model.addAttribute("next", next);
        model.addAttribute("category", category);
        model.addAttribute("posts", posts);
        model.addAttribute("pages", pages);
        model.addAttribute("page", page);

        return view;
    }

    @PostMapping("/posting")
    public String posting(@ModelAttribute PostDTO postDTO, Model model) {
        // + Permission check
        boardService.insertPost(postDTO);

        return "redirect:/board?categoryId=" + postDTO.getCategoryId();
    }

    @GetMapping("/post")
    public String viewPost(@RequestParam long id, Model model) {
        Post post = boardService.selectPostByPostId(id);
        model.addAttribute("post", post);

        return "post";
    }
}
