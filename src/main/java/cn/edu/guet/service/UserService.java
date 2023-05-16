package cn.edu.guet.service;

import cn.edu.guet.bean.User;

import java.util.List;

/**
 * @Author liwei
 * @Date 2023/5/16 20:20
 * @Version 1.0
 */
public interface UserService {
    String saveUser(User user);
    List<User> viewUser();
    //缺少删除、修改
}
