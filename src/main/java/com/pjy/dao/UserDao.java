package com.pjy.dao;

import com.pjy.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("userDao")
public interface UserDao {
    /**
     * 根据用户名和密码查询用户信息
     * @param uname
     * @param pwd
     * @return 返回查询到都用户信息
     */
    @Select("select * from t_user where uname=#{uname} and pwd=#{pwd}")
    User checkLoginDaO(@Param("uname") String uname,@Param("pwd") String pwd);
    /**
     *更新用户新密码
     * @param pwd
     * @param uid
     * @return
     */
    @Update("update t_user set pwd=#{pwd} where uid=#{uid}")
    int userChangePwdDao(@Param("pwd")String pwd,@Param("uid") int uid);

    /**
     * 查询所有用户信息
     * @return
    stash

     */
    @Select("select * from t_user")
    List<User> userShowDao();

    /**
     * 注册新用户
     * @return
     */
    @Insert("insert into t_user (uname,pwd,age,sex,birth)values(#{uname},#{pwd},#{age},#{sex},#{birth})")
    int userRegDao(User user);
}
