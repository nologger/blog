package kim.main.controller;

import kim.post.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {
    
    @GetMapping("/")
    public String moveMain(HttpServletRequest request, Model model) {
        List<String> categoires = new ArrayList<>();
        Arrays.stream(Category.categories.values()).forEach(category -> categoires.add(category.name().toLowerCase()));

        // admin mode
        if (request.getSession().getAttribute("admin") != null) {
            categoires.add("POSTING".toLowerCase());
        }

        model.addAttribute("categories", categoires);
        return "index";
    }

    @GetMapping("/admin")
    public String moveAdmin() {

        return "admin";
    }
}
