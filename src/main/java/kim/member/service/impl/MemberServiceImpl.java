package kim.member.service.impl;

import kim.member.model.Admin;
import kim.member.model.dto.AdminDTO;
import kim.member.repository.MemberRepository;
import kim.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Admin selectByAdminDTO(AdminDTO adminDTO) {
        Admin admin = memberRepository.selectByAdminDTO(adminDTO);

        if (admin == null) {
            throw new RuntimeException();
        }

        return admin;
    }
}
