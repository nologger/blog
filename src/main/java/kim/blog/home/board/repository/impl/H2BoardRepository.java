package kim.blog.home.board.repository.impl;

import kim.blog.home.board.domain.PostVO;
import kim.blog.home.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class H2BoardRepository implements BoardRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<String> getAllPart() {
        return jdbcTemplate.queryForList("SELECT PART FROM BOARD", String.class);
    }

    @Override
    public List<PostVO> getPosts() {
        return jdbcTemplate.query("SELECT * FROM BOARD ORDER BY SEQUENCE DESC",
                (rs, rowNum) -> {
                    return new PostVO(
                            rs.getLong("SEQUENCE"),
                            rs.getTimestamp("CREATEDAT").toLocalDateTime().toLocalDate(),
                            rs.getTimestamp("MODIFIEDAT").toLocalDateTime().toLocalDate(),
                            rs.getString("PART"),
                            rs.getString("WRITER"),
                            rs.getString("TITLE"),
                            rs.getString("CONTENT")
                    );
                }
            );
    }

    @Override
    public PostVO getPost(long sequence) {
        return jdbcTemplate.queryForObject("SELECT * FROM BOARD WHERE SEQUENCE=?",
                (rs, rowNum) -> {
                    return new PostVO(
                            rs.getLong("SEQUENCE"),
                            rs.getTimestamp("CREATEDAT").toLocalDateTime().toLocalDate(),
                            rs.getTimestamp("MODIFIEDAT").toLocalDateTime().toLocalDate(),
                            rs.getString("PART"),
                            rs.getString("WRITER"),
                            rs.getString("TITLE"),
                            rs.getString("CONTENT")
                    );
                },
                sequence
        );
    }

    @Override
    public List<PostVO> getPosts(String part) {


        return null;
    }
}
