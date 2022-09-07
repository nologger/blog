package kim.member.service.impl;

import kim.member.model.Member;
import kim.member.model.dto.MemberDTO;
import kim.member.repository.MemberRepository;
import kim.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member selectMember(MemberDTO memberDTO) {
        Member member = memberRepository.selectMember(memberDTO);
        return member;
    }
}
