package kim.blog.main.member.repository.impl;

import kim.blog.main.member.domain.Member;
import kim.blog.main.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer selectByAccount(Member member) {
        return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) as COUNT FROM MEMBER WHERE ACCOUNT=?",
                (rs, rowNum) -> {
                    return Integer.parseInt(rs.getString("COUNT"));
                },
                member.getAccount()
        );
    }

    @Override
    public Member selectMember(Member member) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM MEMBER WHERE ACCOUNT=? AND PASSWORD=?",
                (rs, rowNum) -> {
                    return new Member(
                            rs.getString("sequence"),
                            rs.getString("account"),
                            "",
                            rs.getString("authority"),
                            rs.getTimestamp("createdAt").toLocalDateTime().toLocalDate()
                    );
                },
                member.getAccount(),
                member.getPassword()
        );
    }

    @Override
    public long selectNextMaxSequence() {
        return jdbcTemplate.queryForObject(
                "SELECT MAX(SEQUENCE) + 1 as COUNT FROM MEMBER",
                (rs, rowNum) -> {
                    return Long.parseLong(rs.getString("count"));
                }
        );
    }

    @Override
    public void insertMember(long sequence, Member member) {
        jdbcTemplate.update(
                "INSERT INTO MEMBER VALUES(?, ?, ?, 'basic', now())",
                sequence,
                member.getAccount(),
                member.getPassword()
        );
    }
}
