package com.crep.mapper;

import com.crep.entity.Admin;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdminMapper {

    @Select("SELECT * FROM admin WHERE admin_id = #{adminId}")
    Admin selectByPrimaryKey(@Param("adminId") Integer adminId);

    @Delete("DELETE FROM admin WHERE admin_id = #{adminId}")
    int deleteByPrimaryKey(@Param("adminId") Integer adminId);

    @Insert("INSERT INTO admin (admin_name, password) VALUES (#{adminName}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "adminId")
    int insert(Admin admin);

    @Update("UPDATE admin SET admin_name = #{adminName}, password = #{password} WHERE admin_id = #{adminId}")
    int updateByPrimaryKey(Admin admin);

    // 其它可能的Mapper操作
}