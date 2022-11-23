package kim.blog.post.controller;

import kim.blog.post.service.PostService;
import kim.blog.utils.markdown.MarkDownManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private MarkDownManager markDownManager;
    @Autowired
    private PostService postService;

    @PostMapping("/posting")
    public String posting(String content, Model model) {
        String error = markDownManager.validation(content);
        if (!error.isEmpty()) {
            model.addAttribute("error", error)
        }

        // postService.insertPost(content);
        return "/posts";
    }
}
