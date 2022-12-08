package kim.blog.home.controller;

import kim.blog.common.pathInfo.domain.PathInfo;
import kim.blog.common.pathInfo.service.PathInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Slf4j
@Controller
public class HomeController {
    @Autowired
    private PathInfoService pathInfoService;

    @GetMapping("/")
    public RedirectView index() {
        return new RedirectView("/home");
    }

    @GetMapping("/home")
    public String home(Model model) {
        // set categories
        List<PathInfo> categories = pathInfoService.getCommonPathInfo();
        model.addAttribute("categories", categories);

        return "home";
    }
}
