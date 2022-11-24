package kim.blog.common.category.repository.impl;

import kim.blog.common.category.repository.CategoryRepository;
import kim.blog.common.category.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class H2CategoryRepository implements CategoryRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CategoryVO> selectMainCategories() {
        return jdbcTemplate.query(
                "select * from CATEGORY where part='main' order by sequence",
                (rs, rowNum) -> new CategoryVO(
                        rs.getLong("sequence"),
                        rs.getString("id"),
                        rs.getString("part"),
                        rs.getString("title"),
                        rs.getString("link"),
                        rs.getString("createdAt"),
                        rs.getString("modifiedAt")
                )
        );
    }

    @Override
    public List<CategoryVO> selectAdminCategories() {
        return jdbcTemplate.query(
                "select * from CATEGORY where part='admin' order by sequence",
                (rs, rowNum) -> new CategoryVO(
                        rs.getLong("sequence"),
                        rs.getString("id"),
                        rs.getString("part"),
                        rs.getString("title"),
                        rs.getString("link"),
                        rs.getString("createdAt"),
                        rs.getString("modifiedAt")
                )
        );
    }

    @Override
    public List<CategoryVO> selectPostCategories() {
        return jdbcTemplate.query(
                "select * from CATEGORY where part='post' order by sequence",
                (rs, rowNum) -> new CategoryVO(
                        rs.getLong("sequence"),
                        rs.getString("id"),
                        rs.getString("part"),
                        rs.getString("title"),
                        rs.getString("link"),
                        rs.getString("createdAt"),
                        rs.getString("modifiedAt")
                )
        );
    }
}
