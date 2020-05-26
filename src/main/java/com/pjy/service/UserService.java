package com.pjy.service;

import com.pjy.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserService {
    /**
     * 根据用户名和密码查询用户信息
     * @param uname
     * @param pwd
     * @return 返回查询到都用户信息
     */
    User checkLoginDaO(@Param("uname") String uname, @Param("pwd") String pwd);

    /**
     *更新用户新密码
     * @param pwd
     * @param uid
     * @return
     */
    int userChangePwdDao(@Param("pwd")String pwd,@Param("uid") int uid);
    /**
     * 查询所有用户信息
     * @return
     */

    List<User> userShowDao();

    /**
     * 注册新用户
     * @return
     */
    int userRegDao(User user);
}


