package kim.blog.interceptor;

import kim.blog.category.service.CategoryService;
import kim.blog.config.properties.SiteProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Component
public class CategoryInterceptor implements HandlerInterceptor {
    @Autowired
    private SiteProperties siteProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        setSiteProperties(session);

        return true;
    }

    private void setSiteProperties(HttpSession session) {
        if (session.getAttribute("siteTitle") == null) {
            session.setAttribute("siteTitle", siteProperties.getTitle());
            log.info("get siteTitle: {}", siteProperties.getTitle());
            log.info("set siteTitle: {}", session.getAttribute("siteTitle"));
        }
        if (session.getAttribute("siteAuthor") == null) {
            session.setAttribute("siteAuthor", siteProperties.getAuthor());
            log.info("set siteAuthor: {}", session.getAttribute("siteAuthor"));
        }
    }
}
