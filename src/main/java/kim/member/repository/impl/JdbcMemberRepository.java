package kim.member.repository.impl;

import kim.member.model.Admin;
import kim.member.model.dto.AdminDTO;
import kim.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

public class JdbcMemberRepository implements MemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Admin selectByAdminDTO(AdminDTO adminDTO) {
        // select * from member where authority='admin' and account=? and password=? and pinNumber=?

        return null;
    }
}
