package kim.blog.main.member.service.impl;

import kim.blog.common.Utils.Digest;
import kim.blog.main.member.domain.Member;
import kim.blog.main.member.repository.MemberRepository;
import kim.blog.main.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member signIn(Member member) {
        return memberRepository.selectMember(member);
    }

    @Override
    public void signUp(Member member) throws NoSuchAlgorithmException {
        long sequence = memberRepository.selectNextMaxSequence();
        log.info("sequence={}", sequence);
        memberRepository.insertMember(sequence, member);
    }

    @Override
    public boolean isAccountAvailable(Member member) {
        return memberRepository.selectByAccount(member) == 0 ? true : false;
    }
}
