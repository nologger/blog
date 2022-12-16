package kim.blog.home.member.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class Member {
    final String authority;
    final String account;
    final String password;
    final String name;
    final LocalDate createdAt;
}
