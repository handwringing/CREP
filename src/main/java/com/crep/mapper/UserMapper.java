package com.crep.mapper;

import com.crep.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE user_id = #{userId}")
    User selectByPrimaryKey(@Param("userId") Integer userId);

    @Insert("INSERT INTO user (username, password, email, phone_number, register_date, credit_score) " +
            "VALUES (#{username}, #{password}, #{email}, #{phoneNumber}, #{registerDate}, #{creditScore})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(User user);

    @Update("UPDATE user SET username = #{username}, password = #{password}, email = #{email}, " +
            "phone_number = #{phoneNumber}, register_date = #{registerDate}, credit_score = #{creditScore} " +
            "WHERE user_id = #{userId}")
    int updateByPrimaryKey(User user);

    @Delete("DELETE FROM user WHERE user_id = #{userId}")
    int deleteByPrimaryKey(@Param("userId") Integer userId);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(@Param("username") String username);

    @Select("SELECT * FROM user")
    List<User> findAllUsers();
    // Additional methods can be declared as needed, for example:
    // - Finding a user by username.
    // - Updating specific fields like email or password.
    // - Retrieving a list of users with pagination.
}