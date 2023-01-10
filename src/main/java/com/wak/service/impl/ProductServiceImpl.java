package com.wak.service.impl;

import com.github.pagehelper.PageHelper;
import com.wak.domain.Product;
import com.wak.mapper.ProductMapper;
import com.wak.service.ProductService;
import com.wak.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author wak
 */
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> list(String currentPage, String pageSize, String name) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
            PageHelper.startPage(Integer.parseInt(currentPage), Integer.parseInt(pageSize));
            return mapper.list(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insert(Product product) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
            return mapper.insert(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Product product) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
            return mapper.updateByPrimaryKey(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteOne(Long id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
            return mapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int batchDelete(List<Long> ids) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
            return mapper.batchDelete(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
