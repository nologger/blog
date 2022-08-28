package kim.member.repository.impl;

import kim.member.model.Admin;
import kim.member.model.dto.AdminDTO;
import kim.member.repository.MemberRepository;
import org.springframework.stereotype.Repository;

import java.security.cert.CertificateException;

@Repository
public class H2MemberRepository implements MemberRepository {
    @Override
    public Admin selectByAdminDTO(AdminDTO adminDTO) {
        if (!"1721046@gmail.com".equals(adminDTO.getAccount())
                || !"poi098!@".equals(adminDTO.getPassword())
                || !"127000".equals(adminDTO.getPinNumber())) {
            throw new RuntimeException();
        }

        return new Admin();
    }
}
