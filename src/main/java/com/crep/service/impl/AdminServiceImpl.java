package com.crep.service.impl;

import com.crep.entity.Admin;
import com.crep.mapper.AdminMapper;
import com.crep.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public Admin getAdminById(Integer adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }

    @Override
    @Transactional
    public boolean createAdmin(Admin admin) {
        return adminMapper.insert(admin) > 0;
    }

    @Override
    @Transactional
    public boolean updateAdmin(Admin admin) {
        return adminMapper.updateByPrimaryKey(admin) > 0;
    }

    @Override
    @Transactional
    public boolean deleteAdmin(Integer adminId) {
        return adminMapper.deleteByPrimaryKey(adminId) > 0;
    }
}