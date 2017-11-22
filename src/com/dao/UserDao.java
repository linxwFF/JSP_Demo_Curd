package com.dao;

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

public class UserDao {

    // 添加用户的操作
    public boolean insert(User user) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String sql = "INSERT INTO users(role,nickname,name,password,gender,email,tel) " +
                    "VALUES("
                    + user.getRole()
                    + ",'"
                    + user.getNickname()
                    + "','"
                    + user.getName()
                    + "','"
                    + user.getPassword()
                    + "',"
                    + user.getGender()
                    + ",'"
                    + user.getEmail()
                    + "','"
                    + user.getTel()
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

    // 查询所有的User对象
    public ArrayList<User> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<User>();
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            String sql = "SELECT * FROM users";
            rs = stmt.executeQuery(sql);
            // 处理结果集
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
//                user.setBirthday(rs.getDate("birthday"));
                list.add(user);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }
    // 根据id查找指定的user
    public User find(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            String sql = "SELECT * FROM users WHERE id=" + id;
            rs = stmt.executeQuery(sql);
            // 处理结果集
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                return user;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
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
            String sql = "DELETE FROM users WHERE id=" + id;
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
    // 修改用户
    public boolean update(User user) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            String birthday = sdf.format(user.getBirthday());
            String sql = "UPDATE users set name='" + user.getName()
                    + "',password='" + user.getPassword() + "',email='"
                    + user.getEmail()
                    + "' WHERE id=" + user.getId();
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

    //查询用户名密码
    public User login(String name,String password)
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            String sql = "SELECT * FROM users WHERE name='" + name +"' and password='" + password+"'";
            rs = stmt.executeQuery(sql);
            // 处理结果集
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setRole(rs.getInt("role"));
                user.setNickname(rs.getString("nickname"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getInt("gender"));
                user.setEmail(rs.getString("email"));
                user.setTel(rs.getString("tel"));
                return user;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    public boolean validateAlreadyRegister(String name)
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
            stmt = conn.createStatement();
            // 发送SQL语句
            String sql = "SELECT * FROM users WHERE name='" + name +"'";
            rs = stmt.executeQuery(sql);
            // 处理结果集
            while (rs.next()) {
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
}
