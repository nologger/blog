package kim.member.controller;

import kim.board.service.BoardService;
import kim.member.model.Member;
import kim.member.model.dto.MemberDTO;
import kim.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class MemberController {

    @Autowired
    MemberService memberService;
    @Autowired
    BoardService boardService;


    @GetMapping("/admin")
    public String moveAdmin(@SessionAttribute Member member, Model model) {
        if (member != null) {
            return "redirect:/";
        }
        return "admin";
    }
    @PostMapping("/signIn")
    public String signIn(@ModelAttribute MemberDTO memberDTO, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();

        try {
            Member member = memberService.selectMember(memberDTO);
            session.setAttribute("member", member);
        } catch (EmptyResultDataAccessException e){
            log.info("EmptyResultDataAccessExcpetion: {}", memberDTO);
            return "redirect:/admin";
        } catch (Exception e) {
            log.info("LoginFailException: {}", memberDTO);
            return "redirect:/admin";
        }

        // Reset categories
        session.setAttribute("categories", boardService.getCategoriesForGuest().addAll(boardService.getCategoriesForAdmin()));
        return "redirect:/";
    }
}
