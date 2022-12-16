package kim.blog.home.member.repository;

import kim.blog.home.member.domain.Member;

public interface MemberRepository {
    public void insertMember(Member member);
    public Member selectForAccount(Member member);
}
