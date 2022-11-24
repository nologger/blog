package kim.blog.common.category.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CategoryVO {
    final long sequence;
    final String id;
    final String part;
    final String title;
    final String link;
    final String createdAt;
    final String modifiedAt;
}
