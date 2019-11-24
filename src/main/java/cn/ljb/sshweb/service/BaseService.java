package cn.ljb.sshweb.service;


import cn.ljb.sshweb.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> implements BaseServiceI<T> {

    @Autowired
    public BaseDao<T> baseDao;

    @Override
    public void add(T t) {
        baseDao.add(t);
    }

    @Override
    public void delete(int id) {
        baseDao.delete(id);
    }

    @Override
    public void update(T t) {
        baseDao.update(t);
    }

    @Override
    public T getOne(int id) {
        return baseDao.getOne(id);
    }
}
