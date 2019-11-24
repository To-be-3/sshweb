package cn.ljb.sshweb.service;

import cn.ljb.sshweb.model.User;

import java.util.List;

public interface UserService extends BaseServiceI<User> {

    public List<User> getAllUsers();
}
