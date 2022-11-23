package kim.blog.admin.service;

import kim.blog.admin.vo.Admin;

import java.security.NoSuchAlgorithmException;

public interface AdminService {
    public Admin signIn(Admin admin) throws NoSuchAlgorithmException;
}
