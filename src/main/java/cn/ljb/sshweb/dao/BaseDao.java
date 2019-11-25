package cn.ljb.sshweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
@Repository("baseDao")
public class BaseDao<T> implements BaseDaoI<T>{
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(T t) {
        getSession().save(t);
    }

    public void delete(int id) {
        getSession().delete(getOne(id));
    }

    @Override
    public void update(T t) {
        getSession().update(t);
    }

    public T getOne(int id) {
        return getSession().load(getTClass(),id);
    }

    public Class<T> getTClass(){
        Class<T> tClass;
        ParameterizedType type= (ParameterizedType) this.getClass().getGenericSuperclass();
        tClass= (Class<T>) type.getActualTypeArguments()[0];
        return tClass;
    }
}
