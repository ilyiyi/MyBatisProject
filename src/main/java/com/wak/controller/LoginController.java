package com.wak.controller;

import com.wak.domain.User;
import com.wak.service.UserService;
import com.wak.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wak
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        User user = userService.login(account, password);
        if (user != null) {
            //登录成功，将用户信息存到session中，并跳转到商品页面
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/product.html").forward(req, resp);
        } else {

        }
    }
}
