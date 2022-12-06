package kim.blog.main.member.controller;

import kim.blog.main.member.domain.Member;
import kim.blog.main.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/signIn")
    public String signIn(HttpSession session) {
        // check member in session
        if (session.getAttribute("member") != null) {
            return "redirect:/home";
        }

        return "/member/signIn";
    }

    @PostMapping("/signIn")
    public String signInProcess(Member member, HttpSession session) {
        // check member in session
        if (session.getAttribute("member") != null) {
            return "redirect:/home";
        }

        // sign in process
        try {
            member = memberService.signIn(member);
        } catch (EmptyResultDataAccessException e) {
            log.info("[fail] sign in member={}", member);
            return "/member/signIn";
        }

        // register Member
        session.setAttribute("member", member);

        return "redirect:/home";
    }

    @GetMapping("/signUp")
    public String signUp(Member member, HttpSession session) {
        // check member in session
        if (session.getAttribute("member") != null) {
            return "redirect:/home";
        }

        return "/member/signUp";
    }

    @PostMapping("/signUp")
    public String signUpProcess(Member member, HttpSession session, Model model) throws NoSuchAlgorithmException {
        // sign up validation
        Map<String, String> errors = signUpValidation(member);
        if (errors.size() != 0) {
            log.info("validation fail={}", errors.getOrDefault("duplicate", ""));
            log.info("validation fail={}", errors.getOrDefault("account", ""));
            log.info("validation fail={}", errors.getOrDefault("password", ""));
            model.addAttribute("errors", errors);
            return "/member/signUp";
        }

        // sign up process
        memberService.signUp(member);
        session.setAttribute("member", member);

        return "redirect:/home";
    }

    private Map<String, String> signUpValidation(Member member) {
        Map<String, String> errors = new HashMap<>();

        if (!memberService.isAccountAvailable(member)) {
            errors.put("duplicate", "This account is disabled.");
        }
        if (member.getAccount().isEmpty()) {
            errors.put("account", "Account is mandatory.");
        }
        if (member.getPassword().isEmpty()) {
            errors.put("password", "Password is mandatory.");
        }

        return errors;
    }
}
