package kim.blog.utils.markdown;

import org.springframework.stereotype.Component;

@Component
public class MarkDownManager {
    public String validation(String content) {
        if (!content.startsWith("#")) {
            return "시작줄은 반드시 제목('#')으로 시작하여야 합니다.";
        } else if (content.indexOf("#") != content.lastIndexOf("#")) {
            return "제목('#')은 반드시 한 번만 입력이 가능합니다.";
        }

        return null;
    }
}
