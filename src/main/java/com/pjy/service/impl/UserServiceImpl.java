package com.pjy.service.impl;

import com.pjy.dao.UserDao;
import com.pjy.pojo.User;
import com.pjy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    /**
     * 用户登录
     * @param uname
     * @param pwd
     * @return
     */
    @Override
    public User checkLoginDaO(String uname, String pwd) {
        return userDao.checkLoginDaO(uname,pwd);
    }

    /**
     * 修改密码
     * @param pwd
     * @param uid
     * @return
     */
    @Override
    public int userChangePwdDao(String pwd, int uid) {
        return userDao.userChangePwdDao(pwd,uid);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<User> userShowDao() {
        return userDao.userShowDao();
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public int userRegDao(User user) {
        return userDao.userRegDao(user);
    }
}
