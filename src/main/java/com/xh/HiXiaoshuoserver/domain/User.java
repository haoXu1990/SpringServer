package com.xh.HiXiaoshuoserver.domain;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: HiXiaoshuo-server
 * @description: 用户模型
 * @author: XuHao
 * @create: 2018-07-20 09:52
 **/
public class User {

    // 用户ID
    private Long uid;

    // 用户登录名, 不可改
    private String uname;

    // 用户昵称, 可以更改
    private String nick;

    // 已经加密的登录密码
    private String pwd;

    // 加密盐值
    private String salt;

    // 创建时间
    private Date created;

    // 修改时间
    private Date updated;

    // 用户角色值, 用于shiro做角色权限的判断
    private Set<String> roles = new HashSet<>();

    // 用户权限, 用于shiro 做资源权限的判断
    private Set<String> perms = new HashSet<>();


    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getPerms() {
        return perms;
    }

    public void setPerms(Set<String> perms) {
        this.perms = perms;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", nick='" + nick + '\'' +
                ", pwd='" + pwd + '\'' +
                ", salt='" + salt + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", roles=" + roles +
                ", perms=" + perms +
                '}';
    }
}
