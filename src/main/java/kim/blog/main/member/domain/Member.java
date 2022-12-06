package kim.blog.main.member.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@RequiredArgsConstructor
@ToString
public class Member {
    final String sequence;
    final String account;
    final String password;
    final String authority;
    final LocalDate createdAt;
}
