package kim.post.controller;

import kim.post.model.Post;
import kim.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/java")
    public String getJava(Model model) {
        model.addAttribute("category", "Java");
        return "post/layout";
    }

    @GetMapping("/spring")
    public String getSpring(Model model) {
        model.addAttribute("category", "Spring");
        return "post/layout";
    }

    @GetMapping("/life")
    public String getLife(Model model) {
        model.addAttribute("category", "Life");
        return "post/layout";
    }

    @GetMapping("/fullPost")
    public String fullPost(Model model) {
        model.addAttribute("category", "Full Post");
        return "post/layout";
    }

    @GetMapping("/search")
    public String searchPost(@RequestParam String keyword, Model model) {
        model.addAttribute("category", String.format("Search: {}", keyword));
        return "post/layout";
    }

    @GetMapping("/posting")
    public String getPost(Model model) {
        return "post/posting";
    }

    @GetMapping("/viewPost")
    public String viewPost(Model model) {
        return "post/viewPost";
    }
}
