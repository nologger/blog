package kim.blog.admin.controller;

import kim.blog.admin.service.AdminService;
import kim.blog.admin.vo.Admin;
import kim.blog.category.service.CategoryService;
import kim.blog.config.properties.SiteProperties;
import kim.blog.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private SiteProperties siteProperties;
    @Autowired
    private AdminService adminService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String admin(Model model, HttpSession session) {
        model.addAttribute("adminCategories", categoryService.getAdminCategories());
        return "/admin/admin";
    }

    @PostMapping("/signIn")
    public String checkSignIn(Admin admin, HttpSession session) throws NoSuchAlgorithmException {
        admin = adminService.signIn(admin);
        if (admin != null) {
            session.setAttribute("admin", admin);
            return "redirect:/admin";
        }
        return "/admin/signIn";
    }

    @GetMapping("/posting")
    public String posting() {
        return "/admin/posting";
    }

    @PostMapping("/posting")
    public String posting(String content) {
        if (!content.startsWith("# ")) {
            return "/admin/posting";
        }

        return "/posts";
    }
}
