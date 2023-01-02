package kim.blog.admin.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Admin {
    final List<String> ip;
    final String account;
    final String email;
    final String password;
    final String pinNumber;
    final int numOfFailAccess;
}
