package kim.blog.common.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("site")
public class SiteProperties {
    @Value("${site.title}")
    private String title;
    @Value("${site.author}")
    private String author;
}
