package kim.blog.common.config;

import kim.blog.common.interceptor.AuthorityInterceptor;
import kim.blog.common.interceptor.CategoryInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    CategoryInterceptor categoryInterceptor;

    @Autowired
    AuthorityInterceptor authorityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(categoryInterceptor);
        registry.addInterceptor(authorityInterceptor)
                .excludePathPatterns("/member/signIn")
                .excludePathPatterns("/member/signUp");
    }
}
