package kim.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Category {
    long id;
    String title;
    String viewPath;
}
