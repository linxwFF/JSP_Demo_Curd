package com.dao;

import com.pojo.Product;
import com.pojo.User;
import com.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by LINxwFF on 2017/11/21.
 */
public class ProductDao {

    // 查询所有的Product对象
    public ArrayList<Product> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            String sql = "SELECT * FROM products";
            rs = stmt.executeQuery(sql);
            // 处理结果集
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setUuid(rs.getInt("uuid"));
                product.setName(rs.getString("name"));
                product.setQuantity(rs.getInt("quantity"));
                product.setTs(rs.getString("ts"));
                product.setDate_of_manufacture(rs.getDate("date_of_manufacture"));
                product.setShelf_life(rs.getInt("shelf_life"));
                product.setVendor(rs.getString("vendor"));
                product.setSupplier(rs.getString("supplier"));
                list.add(product);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    // 添加商品的操作
    public boolean insert(Product product) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            String sql = "INSERT INTO products(uuid,name,ts,quantity,date_of_manufacture,shelf_life,vendor,supplier) " +
                    "VALUES("
                    + product.getUuid()
                    + ",'"
                    + product.getName()
                    + "','"
                    + product.getTs()
                    + "',"
                    + product.getQuantity()
                    + ","
                    + "now()"
                    + ","
                    + product.getShelf_life()
                    + ",'"
                    + product.getVendor()
                    + "','"
                    + product.getSupplier()
                    + "')";
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return false;
    }

    // 根据id查找指定的Product
    public Product find(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            String sql = "SELECT * FROM products WHERE id=" + id;
            rs = stmt.executeQuery(sql);
            // 处理结果集
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setUuid(rs.getInt("uuid"));
                product.setName(rs.getString("name"));
                product.setQuantity(rs.getInt("quantity"));
                product.setTs(rs.getString("ts"));
                product.setDate_of_manufacture(rs.getDate("date_of_manufacture"));
                product.setShelf_life(rs.getInt("shelf_life"));
                product.setVendor(rs.getString("vendor"));
                product.setSupplier(rs.getString("supplier"));

                return product;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    // 修改用户
    public boolean update(Product product) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            String sql = "UPDATE products set " +
                    "uuid=" + product.getUuid()
                    + ",name='" + product.getName()
                    + "',ts='"+ product.getTs()
                    + "',quantity=" + product.getQuantity()
                    +", date_of_manufacture = now()"
                    + ",shelf_life="+ product.getShelf_life()
                    + ",vendor='" + product.getVendor()
                    + "',supplier='" + product.getSupplier()
                    + "' WHERE id=" + product.getId();
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return false;
    }

    // 删除用户
    public boolean delete(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            String sql = "DELETE FROM products WHERE id=" + id;
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return false;
    }

    public ArrayList<Product> query(String name)
    {
        String Name = new StringBuffer("%").append(name).append("%").toString();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Product> list = new ArrayList<Product>();
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            String sql = "SELECT * FROM products where name LIKE '"+Name+"' OR uuid = "+ name;
            rs = stmt.executeQuery(sql);
            // 处理结果集
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setUuid(rs.getInt("uuid"));
                product.setName(rs.getString("name"));
                product.setQuantity(rs.getInt("quantity"));
                product.setTs(rs.getString("ts"));
                product.setDate_of_manufacture(rs.getDate("date_of_manufacture"));
                product.setShelf_life(rs.getInt("shelf_life"));
                product.setVendor(rs.getString("vendor"));
                product.setSupplier(rs.getString("supplier"));
                list.add(product);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }
}
