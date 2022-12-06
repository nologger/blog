package kim.blog.main.member.repository;

import kim.blog.main.member.domain.Member;

public interface MemberRepository {
    public Integer selectByAccount(Member member);
    public Member selectMember(Member member);
    public long selectNextMaxSequence();
    public void insertMember(long sequence, Member member);
}
