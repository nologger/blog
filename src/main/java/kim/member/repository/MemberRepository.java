package kim.member.repository;

import kim.member.model.Admin;
import kim.member.model.dto.AdminDTO;

public interface MemberRepository {
    public Admin selectByAdminDTO(AdminDTO adminDTO);
}
