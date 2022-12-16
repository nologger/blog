package kim.blog.home;

import kim.blog.common.pathInfo.service.PathInfoService;
import kim.blog.home.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class HomeController {
    @Autowired
    private PathInfoService pathInfoService;

    @GetMapping("/")
    public String home(HttpSession httpSession, Model model) {
        // set common categories
        model.addAttribute("commonCategories", pathInfoService.getCategories("common"));

        // set member categories
        Member member = (Member)httpSession.getAttribute("member");
        if (member != null) {
            model.addAttribute("memberCategories", pathInfoService.getCategories("member"));
        }

        // set admin categories
        if (member != null && member.getAuthority().equals("admin")) {
            model.addAttribute("adminCategories", pathInfoService.getCategories("admin"));
        }

        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "home/about";
    }
}
