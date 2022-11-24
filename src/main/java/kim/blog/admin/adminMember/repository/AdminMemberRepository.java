package kim.blog.admin.adminMember.repository;

import kim.blog.admin.adminMember.domain.AdminMember;
import kim.blog.admin.adminMember.exception.AdminMemberSignInFailed;

public interface AdminMemberRepository {
    public AdminMember selectByAdminMember(AdminMember adminMember);
}
