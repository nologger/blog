package kim.member.repository.impl;

import kim.exception.LoginFailException;
import kim.member.model.Member;
import kim.member.model.dto.MemberDTO;
import kim.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
@Slf4j
public class JdbcMemberRepository implements MemberRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMemberRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Member selectMember(MemberDTO memberDTO) {
        // Member member = jdbcTemplate.query("select * where account=? and pinNumber=? and password=?");
        Member member = jdbcTemplate.queryForObject(
                "select * from member where account=? and pinNumber=? and password=?",
                (rs, rowNum) -> {
                  Member m = new Member(
                          rs.getString("id"),
                          rs.getString("account"),
                          null,
                          rs.getString("name"),
                          null,
                          rs.getString("phoneNumber"),
                          rs.getTimestamp("createAt").toLocalDateTime(),
                          rs.getString("authority")
                  );

                  return m;
                },
                memberDTO.getAccount(),
                memberDTO.getPinNumber(),
                memberDTO.getPassword()
        );

        if (member == null) {
            throw new LoginFailException();
        }

        return member;
    }
}
