package kim.blog.config;

import kim.blog.interceptor.PathInfoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    PathInfoInterceptor pathInfoInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/home");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        addPathInfoInterceptor(registry);
    }

    private void addPathInfoInterceptor(InterceptorRegistry registry) {
        List<String> excludePaths = new ArrayList<>(List.of(new String[]{"/css/**", "/favicon.ico", "/member/signIn", "/member/signUp"}));
        registry.addInterceptor(pathInfoInterceptor).excludePathPatterns(excludePaths);
    }
}
