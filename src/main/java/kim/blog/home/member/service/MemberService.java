package kim.blog.home.member.service;

import kim.blog.home.member.domain.Member;

public interface MemberService {
    public void signUp(Member member);
    public Member signIn(Member member);
}
