package kim.blog.admin.controller;

import kim.blog.admin.domain.Admin;
import kim.blog.admin.service.AdminAccessServiceImpl;
import kim.blog.common.exception.UrlNotFoundException;
import kim.blog.common.service.HttpRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    HttpRequestService httpRequestService;
    @Autowired
    AdminAccessServiceImpl adminAccessService;

    @GetMapping
    public String admin(HttpSession session, HttpServletRequest request) {
        // Check session information
        Admin admin = (Admin)session.getAttribute("admin");
        if (admin != null) {
            return "/admin/adminIndex";
        }

        // Check access
        if (!adminAccessService.checkAccess(request)) {
            throw new UrlNotFoundException();
        }

        return "/admin/signIn";
    }
}
