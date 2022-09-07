package kim.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostDTO {
    long categoryId;
    String title;
    String summary;
    String content;
}
