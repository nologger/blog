package kim.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Post {
    long id;
    long categoryId;
    String title;
    String summary;
    String content;
    LocalDateTime createAt;
    LocalDateTime modifiedAt;
}
