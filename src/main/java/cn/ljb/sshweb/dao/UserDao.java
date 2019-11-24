package cn.ljb.sshweb.dao;

import cn.ljb.sshweb.model.User;

import java.util.List;

public interface UserDao extends BaseDaoI<User>{
    /*//新增用户到数据库中对用的表中
    public void add(User user);
    //通过id值来删除对应得用户记录
    public void delete(int id);
    //传入一个User对象，更新数据库中与此对应得记录
    public void update(User user);
    //通过id值获取一天数据记录
    public User getOne(int id);*/
    //获取所有User数据记录
    public List<User> getAll();
}
