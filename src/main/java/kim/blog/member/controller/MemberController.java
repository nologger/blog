package kim.blog.member.controller;

import kim.blog.member.domain.Member;
import kim.blog.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/signIn")
    public String signIn() {
        return "/member/signIn";
    }

    @PostMapping("/signIn")
    public String signInProcess(Member member, HttpSession session) {
        member = memberService.signIn(member);

        if (member == null) {
            return "/member/signIn";
        }
        session.setAttribute("member", member);
        return "redirect:/home";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "/member/signUp";
    }

    @PostMapping("/signUp")
    public String signUpProcess(Member member) {
        memberService.signUp(member);
        return "redirect:/home";
    }
}
