package kim.interceptor;

import kim.board.model.Category;
import kim.board.service.BoardService;
import kim.member.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Component
@Slf4j
public class CategoryInterceptor implements HandlerInterceptor {

    @Autowired
    BoardService boardService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        List<Category> categories = boardService.getCategoriesForGuest();

        HttpSession httpSession = request.getSession(false);
        if (httpSession != null) {
            Member member = (Member)httpSession.getAttribute("member");

            List<Category> adminCategories = boardService.getCategoriesForAdmin();
            if (member != null && "admin".equals(member.getAuthority()) && !categories.containsAll(adminCategories)) {
                categories.addAll(boardService.getCategoriesForAdmin());
            }
        }

        httpSession.setAttribute("categories", categories);
    }
}
