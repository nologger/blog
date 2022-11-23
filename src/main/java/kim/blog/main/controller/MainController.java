package kim.blog.main.controller;

import kim.blog.category.service.CategoryService;
import kim.blog.config.properties.SiteProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class MainController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/")
    public RedirectView index() {
        return new RedirectView("/home");
    }

    @GetMapping("/home")
    public String home(HttpServletRequest httpServletRequest, Model model) {
        model.addAttribute("mainCategories", categoryService.getMainCategories());
        return "home";
    }

    @GetMapping("/about")
    public String about(HttpServletRequest httpServletRequest, Model model) {
        return "about";
    }

    @GetMapping("/posts")
    public String posts(HttpServletRequest httpServletRequest, Model model) {
        return "posts";
    }
}
