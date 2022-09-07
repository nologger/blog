package kim.board.repository.impl;

import kim.board.model.Category;
import kim.board.model.Post;
import kim.board.model.dto.PostDTO;
import kim.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JdbcBoardRepository implements BoardRepository {

    private JdbcTemplate jdbcTemplate;
    private class PostRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Post(
                    rs.getLong("id"),
                    rs.getLong("categoryId"),
                    rs.getString("title"),
                    rs.getString("summary"),
                    rs.getString("content"),
                    getLocalDateTime(rs.getTimestamp("createAt")),
                    getLocalDateTime(rs.getTimestamp("modifiedAt"))
            );
        }
    };
    private class CategoryRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Category(
                    rs.getLong("id"),
                    rs.getString("title"),
                    rs.getString("viewPath")
            );
        }
    }

    @Autowired
    public JdbcBoardRepository(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    private LocalDateTime getLocalDateTime(Timestamp timestamp) {
        return timestamp == null ? null : timestamp.toLocalDateTime();
    }

    @Override
    public List<Post> selectPostsByCategory(Category category, int page) {
        return jdbcTemplate.query(
                "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY CREATEAT DESC) AS NUM, * FROM POSTS WHERE CATEGORYID=? ORDER BY CREATEAT DESC) WHERE NUM BETWEEN ? AND ?",
                new PostRowMapper(),
                category.getId(),
                (page - 1) * 5 + 1,
                (page - 1) * 5 + 5
        );
    }

    @Override
    public Category selectCategoryByCategoryId(long categoryId) {
        return (Category) jdbcTemplate.queryForObject(
                "SELECT * FROM CATEGORY WHERE ID=?",
                new CategoryRowMapper(),
                categoryId
        );
    }

    @Override
    public Post selectPostByPostId(long postId) {
        return (Post)jdbcTemplate.queryForObject(
                "SELECT * FROM POSTS WHERE ID=?",
                new PostRowMapper(),
                postId
        );
    }

    @Override
    public void insertPost(PostDTO postDTO) {
        jdbcTemplate.update(
                "INSERT INTO POSTS(categoryId, title, summary, content, createAt, modifiedAt) VALUES(?, ?, ?, ?, now(), now())",
                postDTO.getCategoryId(),
                postDTO.getTitle(),
                postDTO.getSummary(),
                postDTO.getContent()
        );

        return;
    }

    @Override
    public List<Category> selectCategoriesForGuest() {
        return jdbcTemplate.query(
                "SELECT * FROM CATEGORY WHERE NVL(AUTHORITY, '')!='admin'",
                new CategoryRowMapper()
        );
    }

    @Override
    public List<Category> selectCategoriesForAdmin() {
        return jdbcTemplate.query(
                "SELECT * FROM CATEGORY WHERE NVL(AUTHORITY, '')='admin'",
                new CategoryRowMapper()
        );
    }
    @Override
    public List<Post> selectRecentlyPosts(int num) {
        return jdbcTemplate.query(
                "SELECT ROWNUM, * FROM POSTS WHERE ROWNUM BETWEEN 1 AND ? ORDER BY CREATEAT DESC",
                new PostRowMapper(),
                num
        );
    }

    @Override
    public int selectLastPage(long categoryId) {
        return jdbcTemplate.queryForObject(
                "SELECT (COUNT(*) - 1) / 5 + 1 FROM POSTS WHERE categoryId=?",
                Integer.class,
                categoryId
        );
    }
}
