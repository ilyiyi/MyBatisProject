package com.wak.service;

import com.wak.domain.Product;

import java.util.List;

/**
 * @author wak
 */
public interface ProductService {
    /**
     * 查询功能
     *
     * @param currentPage 当前页
     * @param pageSize    每页条数
     * @param name        查询关键词
     * @return 查询到的商品列表
     */
    List<Product> list(String currentPage, String pageSize, String name);

    /**
     * 添加数据
     *
     * @param product 添加的数据
     * @return 受影响行数
     */
    int insert(Product product);

    /**
     * 更新数据
     *
     * @param product 数据
     * @return 受影响行数
     */
    int update(Product product);

    /**
     * 删除一条数据
     *
     * @param id 商品id
     * @return 受影响行数
     */
    int deleteOne(Long id);

    /**
     * 根据id列表批量删除
     *
     * @param ids id列表
     * @return 受影响行数
     */
    int batchDelete(List<Long> ids);
}
