package kim.blog.admin.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean isExistIp(String ip) {
        String query = "SELECT COUNT(*) FROM ADMINISTRATOR WHERE IPADDR1 = ? OR IPADDR2 = ? OR IPADDR3 = ?";

        int count = jdbcTemplate.queryForObject(
                query,
                (rs, rowNum) -> {
                  return rs.getInt("COUNT");
                },
                ip,
                ip,
                ip,
                Integer.class
        );

        if (count == 0) {
            return false;
        }
        return true;
    }
}
