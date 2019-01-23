package com.example.wuyunan.myddl;

/**
 * Created by wuyunan on 18/7/22.
 */

public class Users {
    private String username;
    private String password;
    private String grade;
    private String createtime;

    public Users() {
    }
    public Users(String username, String password, String grade, String createtime) {
        this.username = username;
        this.password = password;
        this.grade = grade;
        this.createtime = createtime;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
