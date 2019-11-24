package cn.ljb.sshweb.service;

import cn.ljb.sshweb.dao.UserDao;
import cn.ljb.sshweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {
    public UserServiceImpl() {
        System.out.println("================================UserServiceImpl被加载到IOC容器");
    }

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAll();
    }
}
