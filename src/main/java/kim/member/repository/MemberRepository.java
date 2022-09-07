package kim.member.repository;

import kim.member.model.Member;
import kim.member.model.dto.MemberDTO;

public interface MemberRepository {
    public Member selectMember(MemberDTO member);
}
