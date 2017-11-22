package com.service;

import com.dao.ProductDao;
import com.pojo.Product;
import com.pojo.User;
import sun.dc.pr.PRError;

import java.util.ArrayList;

/**
 * Created by LINxwFF on 2017/11/21.
 */
public class ProductService {
    private ProductDao productDao = new ProductDao();

    public ArrayList<Product> getList()
    {
        return productDao.findAll();
    }

    public boolean add(Product product)
    {
        return productDao.insert(product);
    }

    //根据ID查询用户信息
    public Product getUserByID(int id)
    {
        return productDao.find(id);
    }

    //更新用户信息
    public boolean update(Product product)
    {
        return productDao.update(product);
    }

    //删除用户
    public boolean delete(int id)
    {
        return productDao.delete(id);
    }

    //查询商品
    public ArrayList<Product> query(String input)
    {
        return productDao.query(input);
    }
}
