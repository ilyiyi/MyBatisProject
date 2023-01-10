package com.wak.mapper;

import com.wak.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wak
 */
public interface UserMapper {
    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return 受影响行数
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据
     *
     * @param row 待插入数据
     * @return 受影响行数
     */
    int insert(User row);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 用户信息
     */
    User selectByPrimaryKey(Long id);

    /**
     * 查询所有
     *
     * @return 用户列表
     */
    List<User> selectAll();

    /**
     * 根据主键更新数据据
     *
     * @param row 更新数据
     * @return 受影响行数
     */
    int updateByPrimaryKey(User row);

    /**
     * 根据account查询用户
     *
     * @param account 账号
     * @return 存在返回User，否则返回null
     */
    User selectByAccount(String account);

    /**
     * 根据account和password查询用户
     *
     * @param account  账号
     * @param password 密码
     * @return 查询到的用户信息
     */
    User selectOne(@Param("account") String account, @Param("password") String password);
}