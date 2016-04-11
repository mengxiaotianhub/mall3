package com.mengxiaotian.meta;

import javax.persistence.*;

@Table(name = "person")
public class Person {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "userName")
    private String userName;

    /**
     * 密码md5加密
     */
    private String password;

    /**
     * 用户昵称
     */
    @Column(name = "nickName")
    private String nickName;

    /**
     * 类型，买家0，卖家1
     */
    @Column(name = "userType")
    private Integer userType;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return userName - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取密码md5加密
     *
     * @return password - 密码md5加密
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码md5加密
     *
     * @param password 密码md5加密
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户昵称
     *
     * @return nickName - 用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置用户昵称
     *
     * @param nickname 用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取类型，买家0，卖家1
     *
     * @return userType - 类型，买家0，卖家1
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置类型，买家0，卖家1
     *
     * @param usertype 类型，买家0，卖家1
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}