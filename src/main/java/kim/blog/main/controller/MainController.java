package kim.blog.main.controller;

import kim.blog.category.service.CategoryService;
import kim.blog.config.properties.SiteProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private SiteProperties siteProperties;
    @Autowired
    private CategoryService categoryService;

    /**
     * @return home.html
     */
    @GetMapping("/home")
    public String home(HttpServletRequest httpServletRequest, Model model) {
        model.addAttribute("siteTitle", siteProperties.getTitle());
        model.addAttribute("siteAuthor", siteProperties.getAuthor());
        model.addAttribute("mainCategories", categoryService.getMainCategories());

        log.info("pathInfo: {}", httpServletRequest.getRequestURL());

        return "home";
    }

    @GetMapping("/about")
    public String about(HttpServletRequest httpServletRequest, Model model) {
        model.addAttribute("siteTitle", siteProperties.getTitle());
        model.addAttribute("siteAuthor", siteProperties.getAuthor());

        log.info("pathInfo: {}", httpServletRequest.getRequestURL());

        return "about";
    }

    @GetMapping("/posts")
    public String posts(HttpServletRequest httpServletRequest, Model model) {
        model.addAttribute("siteTitle", siteProperties.getTitle());
        model.addAttribute("siteAuthor", siteProperties.getAuthor());

        log.info("pathInfo: {}", httpServletRequest.getRequestURL());

        return "posts";
    }
}
