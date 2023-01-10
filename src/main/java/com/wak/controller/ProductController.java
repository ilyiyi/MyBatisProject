package com.wak.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.pagehelper.PageInfo;
import com.wak.domain.Product;
import com.wak.domain.User;
import com.wak.service.ProductService;
import com.wak.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wak
 */
@WebServlet("/product")
public class ProductController extends HttpServlet {

    ProductService service = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        String name = req.getParameter("name");
        List<Product> list = service.list(currentPage, pageSize, name);
        PageInfo<Product> info = new PageInfo<>(list);

        String s = JSON.toJSONString(info);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        Product product = JSON.parseObject(s, Product.class);

        User user = (User) req.getSession().getAttribute("user");

        product.setCreateId(user.getId());
        product.setCreateTime(new Date());
        int i = service.insert(product);
        resp.getWriter().write(i > 0 ? "true" : "false");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String s = req.getReader().readLine();
        Product product = JSON.parseObject(s, Product.class);
        User user = (User) req.getSession().getAttribute("user");
        product.setUpdateId(user.getId());
        product.setUpdateTime(new Date());
        int i = service.update(product);
        resp.getWriter().write(i > 0 ? "true" : "false");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getReader().readLine();
        System.out.println(s);
        JSONObject obj = JSON.parseObject(s);
        Boolean isBatch = obj.getBoolean("isBatch");
        if (isBatch) {
            JSONArray ids = obj.getJSONArray("ids");
            List<Long> idList = new ArrayList<>();
            for (Object i : ids) {
                int num = (int) i;
                Long id = (long) num;
                System.out.println(id);
                idList.add(id);
            }
            int i = service.batchDelete(idList);
            resp.getWriter().write(i == ids.size() ? "true" : "false");
        } else {
            Long id = obj.getLong("id");
            System.out.println(id);
            int i = service.deleteOne(id);
            resp.getWriter().write(i > 0 ? "true" : "false");
        }
    }
}
