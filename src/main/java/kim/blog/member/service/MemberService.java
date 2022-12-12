package kim.blog.member.service;

import kim.blog.member.domain.Member;

public interface MemberService {
    public void signUp(Member member);
    public Member signIn(Member member);
}
