package com.crep;

import com.crep.entity.User;
import com.crep.mapper.UserMapper;
import com.crep.service.UserService;
import com.crep.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    private UserService userService;
    private UserMapper userMapper = Mockito.mock(UserMapper.class);

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userMapper);
    }

    @Test
    void testGetUserById() {
        Integer userId = 1;
        User user = new User();
        user.setUserId(userId);
        when(userMapper.selectByPrimaryKey(userId)).thenReturn(user);

        User found = userService.findById(userId);

        verify(userMapper).selectByPrimaryKey(userId);
        assert found.getUserId().equals(userId);
    }

    // 其他测试...
}