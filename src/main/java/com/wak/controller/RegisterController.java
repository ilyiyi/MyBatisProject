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
@WebServlet("/register")
public class RegisterController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        userService.register(account, password);
        req.getRequestDispatcher("/login.html").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        System.out.println(account);
        boolean res = userService.checkAccount(account);
        System.out.println(res);
        //如果存在响应true，否则响应false
        resp.getWriter().write(res ? "true" : "false");
    }
}
