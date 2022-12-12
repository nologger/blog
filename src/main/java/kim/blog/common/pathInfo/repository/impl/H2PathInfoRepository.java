package kim.blog.common.pathInfo.repository.impl;

import kim.blog.common.pathInfo.domain.PathInfo;
import kim.blog.common.pathInfo.repository.PathInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.nio.file.Path;
import java.util.List;

@Repository
public class H2PathInfoRepository implements PathInfoRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public PathInfo selectByUri(String uri) {
        try {
            PathInfo pathInfo = jdbcTemplate.queryForObject(
                    "SELECT * FROM PATHINFO WHERE URI=?",
                    (rs, rowNum) -> {
                        return new PathInfo(
                                rs.getLong("SEQUENCE"),
                                rs.getString("URI"),
                                rs.getString("TITLE"),
                                rs.getString("PART"),
                                rs.getString("AUTHORITY"),
                                rs.getTimestamp("CREATEDAT").toLocalDateTime().toLocalDate()
                        );
                    },
                    uri
                );
            return pathInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<PathInfo> selectByPart() {
        return jdbcTemplate.query(
                "SELECT * FROM PATHINFO WHERE PART='main' ORDER BY SEQUENCE",
                (rs, rowNum) -> {
                    return new PathInfo(
                            rs.getLong("SEQUENCE"),
                            rs.getString("URI"),
                            rs.getString("TITLE"),
                            rs.getString("PART"),
                            rs.getString("AUTHORITY"),
                            rs.getTimestamp("CREATEDAT").toLocalDateTime().toLocalDate()
                    );
                }
        );
    }
}