package kim.blog.admin.adminMember.service.impl;

import kim.blog.admin.adminMember.domain.AdminMember;
import kim.blog.admin.adminMember.exception.AdminMemberSignInFailed;
import kim.blog.admin.adminMember.repository.AdminMemberRepository;
import kim.blog.admin.adminMember.service.AdminMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminMemberServiceImpl implements AdminMemberService {

    @Autowired
    AdminMemberRepository adminMemberRepository;

    @Override
    public AdminMember signIn(AdminMember adminMember) throws AdminMemberSignInFailed {
        AdminMember member = adminMemberRepository.selectByAdminMember(adminMember);
        if (member == null) {
            throw new AdminMemberSignInFailed();
        }
        return member;
    }
}
