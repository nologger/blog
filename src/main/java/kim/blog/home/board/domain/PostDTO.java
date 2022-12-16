package kim.blog.home.board.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PostDTO {
    String part;
    String writer;
    String title;
    String content;
}
