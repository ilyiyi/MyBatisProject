package com.wak.service.impl;

import com.wak.domain.User;
import com.wak.mapper.UserMapper;
import com.wak.service.UserService;
import com.wak.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author wak
 */
public class UserServiceImpl implements UserService {


    @Override
    public boolean checkAccount(String account) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectByAccount(account);
            return user != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User login(String account, String password) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectOne(account, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int register(String account, String password) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setAccount(account);
            user.setPassword(password);

            return mapper.insert(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
