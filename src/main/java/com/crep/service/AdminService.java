package com.crep.service;

import com.crep.entity.Admin;

public interface AdminService {
    Admin getAdminById(Integer adminId);
    boolean createAdmin(Admin admin);
    boolean updateAdmin(Admin admin);
    boolean deleteAdmin(Integer adminId);
}