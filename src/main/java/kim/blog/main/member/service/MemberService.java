package kim.blog.main.member.service;

import kim.blog.main.member.domain.Member;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

public interface MemberService {
    public Member signIn(Member member);
    public void signUp(Member member) throws NoSuchAlgorithmException;
    public boolean isAccountAvailable(Member member);
}
