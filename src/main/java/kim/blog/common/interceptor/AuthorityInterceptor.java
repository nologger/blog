package kim.blog.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class AuthorityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("session attribute member={}", request.getSession().getAttribute("member"));
        log.info("request path={}", request.getRequestURL());
        if (request.getSession().getAttribute("member") == null) {
            response.sendRedirect(request.getContextPath() + "/member/signIn");
            return false;
        }
        return true;
    }
}
