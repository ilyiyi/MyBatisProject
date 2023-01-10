package com.wak.service;

import com.wak.domain.User;

/**
 * @author wak
 */
public interface UserService {
    /**
     * 判断账号是否存在
     *
     * @param account 账号
     * @return 是否存在
     */
    boolean checkAccount(String account);

    /**
     * 添加用户
     *
     * @param account  账号
     * @param password 密码
     * @return 受影响行数
     */
    int register(String account, String password);

    /**
     * 用户登录
     *
     * @param account  账号
     * @param password 密码
     * @return 用户信息
     */
    User login(String account, String password);

}
