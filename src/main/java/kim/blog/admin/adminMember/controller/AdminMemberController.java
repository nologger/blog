package kim.blog.admin.adminMember.controller;

import kim.blog.admin.adminMember.domain.AdminMember;
import kim.blog.admin.adminMember.exception.AdminMemberSignInFailed;
import kim.blog.admin.adminMember.service.AdminMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminMemberController {

    @Autowired
    AdminMemberService adminMemberService;

    @GetMapping("/signIn")
    public String signIn() {
        String view = "/admin/signIn";
        return view;
    }

    @PostMapping("/signIn")
    public String singIn(AdminMember adminMember, HttpSession session, Model model) {
        String view ="/admin/signIn";

        try {
            AdminMember member = adminMemberService.signIn(adminMember);
            session.setAttribute("admin", member);
            view = "redirect:/admin";
        } catch (AdminMemberSignInFailed e) {
            e.printStackTrace();
            log.info("sign in try adminMember: {}", adminMember);
            model.addAttribute("error", "AdminMemberSignInFailed");
            view = "/admin/signIn";
        } catch (Exception e) {
            e.printStackTrace();
            log.info("sign in try adminMember: {}", adminMember);
            model.addAttribute("error", "Exception");
            view = "/admin/signIn";
        }

        return view;
    }
}
