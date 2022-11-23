package kim.blog.admin.repository.impl;

import kim.blog.admin.repository.AdminRepository;
import kim.blog.admin.vo.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class AdminRepositoryImpl implements AdminRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Admin selectAdmin(Admin admin) {
        log.info("admin account: {}", admin.getAccount());
        log.info("admin password: {}", admin.getPassword());
        return jdbcTemplate.queryForObject(
                "select * from ADMIN where account=? AND password=?",
                (rs, rowNum) -> new Admin(
                        rs.getString("account"),
                        rs.getString("password")
                ),
                admin.getAccount(),
                admin.getPassword()
        );
    }
}
