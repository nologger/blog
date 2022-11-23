package kim.blog.admin.service.impl;

import kim.blog.admin.repository.AdminRepository;
import kim.blog.admin.service.AdminService;
import kim.blog.admin.vo.Admin;
import kim.blog.secure.Digest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Admin signIn(Admin admin) {
        try {
            log.info(admin.getPassword());
            admin.setPassword(Digest.SHA256(admin.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        return adminRepository.selectAdmin(admin);
    }
}
