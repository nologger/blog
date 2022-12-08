package kim.blog.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/signIn")
    public String signIn() {
        return "/member/signIn";
    }

    @PostMapping("/signIn")
    public String signInProcess() {
        return "/home";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "/member/signUp";
    }

    @PostMapping("/signUp")
    public String signUpProcess() {
        return "/home";
    }
}
