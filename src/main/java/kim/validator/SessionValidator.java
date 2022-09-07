package kim.validator;

import kim.member.model.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionValidator {
    static public boolean isAdmin(HttpSession httpSession) {
        Member member = (Member)httpSession.getAttribute("member");
        if ("admin".equals(member.getAuthority())) {
            return true;
        }

        return false;
    }
}
