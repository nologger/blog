package kim.member.service;

import kim.member.model.Member;
import kim.member.model.dto.MemberDTO;

public interface MemberService {

    Member selectMember(MemberDTO memberDTO);
}
