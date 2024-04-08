package com.crep.controller;

import com.crep.entity.User;
import com.crep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 用户注册
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        // 用户注册逻辑（需要前端提供的信息：username, password, email等）
        // 需要检查用户名是否已经存在等安全校验（留作注释，具体实现）
        // 密码加密存储等安全措施（留作注释，具体实现）
        int result = userService.createUser(user);
        if (result > 0) {
            return ResponseEntity.ok("注册成功！");
        } else {
            return ResponseEntity.badRequest().body("注册失败");
        }
    }

    // 用户登录
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        // 用户登录逻辑（校验用户名和密码，生成token等操作）
        // 这里假设用username及password查询数据库用户记录
        // 检查用户是否存在以及密码是否正确（留作注释，实际中需要使用加密密码进行比对）
        // 生成JWT token或session（留作注释，具体实现）
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) { // 这里的密码比对在实际应用中需要更安全的方式
            return ResponseEntity.ok().body("登录成功！"); // 实际应用中应返回更多信息，如token
        } else {
            return ResponseEntity.badRequest().body("用户名或密码错误");
        }
    }

    // 更新用户信息
    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Integer userId, @RequestBody User user) {
        // 更新用户信息逻辑，userId为路径变量，user为请求体
        user.setUserId(userId);
        int result = userService.updateUser(user);
        if (result > 0) {
            return ResponseEntity.ok("用户信息更新成功！");
        } else {
            return ResponseEntity.badRequest().body("用户信息更新失败");
        }
    }

    // 删除用户
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
        // 删除用户逻辑
        int result = userService.deleteUser(userId);
        if (result > 0) {
            return ResponseEntity.ok("用户删除成功！");
        } else {
            return ResponseEntity.badRequest().body("用户删除失败");
        }
    }

    // 获取用户信息
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Integer userId) {
        // 根据用户ID获取用户信息
        User user = userService.findById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.badRequest().body("找不到用户");
        }
    }

    // 获取所有用户（适用于管理员）
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        // 获取所有用户列表逻辑
        // 对于管理员功能，需要进行权限校验（留作注释，具体实现）
        List<User> userList = userService.findAllUsers();
        if (userList != null && !userList.isEmpty()) {
            return ResponseEntity.ok(userList);
        } else {
            return ResponseEntity.badRequest().body("没有找到用户信息");
        }
    }

    // 用户登出操作，用户登出后需要销毁token或清除session（留作注释，具体实现）
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestParam String username) {
        // 登出逻辑实现
        // 此处为简单处理，实际应根据token或session操作
        return ResponseEntity.ok("用户登出成功！");
    }
    // 找回密码或重置密码功能（留作注释
}
