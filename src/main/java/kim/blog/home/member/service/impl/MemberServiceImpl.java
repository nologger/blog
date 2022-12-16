package kim.blog.home.member.service.impl;

import kim.blog.home.member.domain.Member;
import kim.blog.home.member.repository.MemberRepository;
import kim.blog.home.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member signIn(Member member) {
        return memberRepository.selectForAccount(member);
    }

    @Override
    public void signUp(Member member) {
        memberRepository.insertMember(member);
    }

}
