package cn.edu.guet.service.impl;

import cn.edu.guet.bean.User;
import cn.edu.guet.dao.UserDao;
import cn.edu.guet.dao.impl.UserDaoImpl;
import cn.edu.guet.service.UserService;

import java.util.List;

/**
 * @Author liwei
 * @Date 2023/5/16 20:25
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        userDao=new UserDaoImpl();
    }

    @Override
    public String saveUser(User user) {
        userDao.saveUser(user);
        return null;
    }

    @Override
    public List<User> viewUser() {
        return userDao.viewUser();
    }
}
