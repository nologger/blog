package kim.blog.home.member.controller;

import kim.blog.home.member.domain.Member;
import kim.blog.home.member.service.MemberService;
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

    @GetMapping
    public String member(HttpSession session) {
        if (session.getAttribute("member") == null) {
            return "/member/signIn";
        }
        return "/member/info";
    }

    @GetMapping("/signIn")
    public String signIn() {
        return "/member/signIn";
    }

    @PostMapping("/signIn")
    public String signInProcess(Member member, HttpSession session) {
        try {
            member = memberService.signIn(member);
            session.setAttribute("member", member);
        } catch (Exception e) {
            return "/member/signIn";
        }
        return "redirect:/";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "/member/signUp";
    }

    @PostMapping("/signUp")
    public String signUpProcess(Member member) {
        memberService.signUp(member);
        return "redirect:/";
    }
}
