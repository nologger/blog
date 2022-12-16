package kim.blog.common.pathInfo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@ToString
public class PathInfo {
    final long sequence;
    final String uri;
    final String title;
    final String part;
    final String authority;
    final LocalDate createdAt;
}
