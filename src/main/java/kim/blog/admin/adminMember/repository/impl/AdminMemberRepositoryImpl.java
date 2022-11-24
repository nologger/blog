package kim.blog.admin.adminMember.repository.impl;


import kim.blog.admin.adminMember.domain.AdminMember;
import kim.blog.admin.adminMember.repository.AdminMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminMemberRepositoryImpl implements AdminMemberRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public AdminMember selectByAdminMember(AdminMember adminMember) {
        return null;
    }
}
