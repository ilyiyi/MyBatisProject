package com.wak.mapper;

import com.wak.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wak
 */
public interface ProductMapper {
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
    int insert(Product row);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 商品信息
     */
    Product selectByPrimaryKey(Long id);

    /**
     * 查询所有
     *
     * @return 商品列表
     */
    List<Product> selectAll();

    /**
     * 根据主键更新数据据
     *
     * @param row 更新数据
     * @return 受影响行数
     */
    int updateByPrimaryKey(Product row);

    /**
     * 根据名字进行查询
     *
     * @param name 查询关键词
     * @return 商品列表
     */
    List<Product> list(@Param("name") String name);

    /**
     * 根据id列表批量删除
     *
     * @param ids id列表
     * @return 受影响行数
     */
    int batchDelete(@Param("ids") List<Long> ids);
}