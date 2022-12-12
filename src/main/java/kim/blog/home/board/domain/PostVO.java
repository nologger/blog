package kim.blog.home.board.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@RequiredArgsConstructor
public class PostVO {
    final long sequence;
    final LocalDate createdAt;
    final LocalDate modifiedAt;
    final String part;
    final String writer;
    final String title;
    final String content;
}
