package kim.member.controller;

import kim.member.model.Admin;
import kim.member.model.dto.AdminDTO;
import kim.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    MemberService memberService;

    @PostMapping("/signIn")
    public String signIn(AdminDTO adminDTO, Model model) {
        // Admin admin = memberService.selectByAdminDTO(adminDTO);
        // model.addAttribute("admin", admin);

        return "index";
    }
}
