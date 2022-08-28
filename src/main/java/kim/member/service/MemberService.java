package kim.member.service;

import kim.member.model.Admin;
import kim.member.model.dto.AdminDTO;

public interface MemberService {
    public Admin selectByAdminDTO(AdminDTO adminDTO);
}
