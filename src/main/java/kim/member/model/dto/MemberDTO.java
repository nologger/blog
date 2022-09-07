package kim.member.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class MemberDTO {
    final String account;
    final String pinNumber;
    final String password;
}
