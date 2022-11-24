package kim.blog.admin.adminMember.service;

import kim.blog.admin.adminMember.controller.AdminMemberController;
import kim.blog.admin.adminMember.domain.AdminMember;
import kim.blog.admin.adminMember.exception.AdminMemberSignInFailed;

public interface AdminMemberService {
    public AdminMember signIn(AdminMember adminMember) throws AdminMemberSignInFailed;
}
