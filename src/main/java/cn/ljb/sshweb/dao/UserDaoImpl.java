package cn.ljb.sshweb.dao;

import cn.ljb.sshweb.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("userDao")
public class UserDaoImpl extends BaseDao<User> implements UserDao{
    public UserDaoImpl() {
        System.out.println("================================UserDaoImpl被加载到IOC容器");
    }

    @Override
    public List<User> getAll() {
        String hql="from User";
        Session session=getSession();
        Query<User> query=session.createQuery(hql);
        return query.list();
    }
}
