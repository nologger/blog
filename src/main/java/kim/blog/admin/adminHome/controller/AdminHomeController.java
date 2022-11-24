package kim.blog.admin.adminHome.controller;

import kim.blog.common.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String admin(Model model, HttpSession session) {
        if (session.getAttribute("admin") == null) {
            return "/admin/signIn";
        }
        model.addAttribute("adminCategories", categoryService.getAdminCategories());
        return "/admin/adminHome";
    }
}
