package cn.edu.guet.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @Author liwei
 * @Date 2023/5/16 19:45
 * @Version 1.0
 */

public class User {
    private int userId;
    private String username;
    private String address;

    public User(int userId, String username, String address) {
        this.userId = userId;
        this.username = username;
        this.address = address;
    }

    public User(String username, String address) {
        this.username = username;
        this.address = address;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
