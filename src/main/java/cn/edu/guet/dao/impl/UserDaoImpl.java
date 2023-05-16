package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.User;
import cn.edu.guet.dao.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author liwei
 * @Date 2023/5/16 20:27
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao {

    @Override
    public int saveUser(User user) {
        Connection conn = null;
        PreparedStatement pstmt;//Statement：语句，PreparedStatement：预编译语句对象
        String url = "jdbc:mysql://localhost:3306/16ban?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "INSERT INTO users(username,address) VALUES(?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "123456");
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getAddress());
            pstmt.executeUpdate();
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public List<User> viewUser() {
        Connection conn = null;
        PreparedStatement pstmt;//Statement：语句，PreparedStatement：预编译语句对象
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/16ban?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "SELECT * FROM users";
        List<User> userList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "123456");
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String address = rs.getString("address");
                User user = new User(id, username, address);
                userList.add(user);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }
}
