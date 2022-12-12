package kim.blog.member.repository;

import kim.blog.member.domain.Member;

public interface MemberRepository {
    public void insertMember(Member member);
    public Member selectForAccount(Member member);
}
