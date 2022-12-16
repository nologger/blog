package kim.blog.home.member.repository.impl;

import kim.blog.home.member.domain.Member;
import kim.blog.home.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class H2MemberRepository implements MemberRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void insertMember(Member member) {
        jdbcTemplate.update(
                "INSERT INTO MEMBER(SEQUENCE, AUTHORITY, ACCOUNT, PASSWORD, NAME, CREATEDAT)" +
                        "VALUES(NEXT VALUE FOR MEMBER_SEQUENCE, 'common', ?, ?, ?, now())",
                member.getAccount(),
                member.getPassword(),
                member.getName()
        );
    }

    @Override
    public Member selectForAccount(Member member) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM MEMBER WHERE ACCOUNT=? AND PASSWORD=?",
                    (rs, rowNum) -> {
                        return new Member(
                                rs.getString("authority"),
                                rs.getString("account"),
                                rs.getString("password"),
                                rs.getString("name"),
                                rs.getTimestamp("createdAt").toLocalDateTime().toLocalDate()
                        );
                    },
                    member.getAccount(),
                    member.getPassword()
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
