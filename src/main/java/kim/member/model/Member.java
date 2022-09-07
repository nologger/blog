package kim.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Member {
    String id;
    String account;
    String password;
    String name;
    String pinNumber;
    String phoneNumber;
    LocalDateTime createAt;
    String authority;
}
