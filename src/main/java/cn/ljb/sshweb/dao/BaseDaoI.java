package cn.ljb.sshweb.dao;

public interface BaseDaoI<T> {
    //新增用户到数据库中对用的表中
    public void add(T t);
    //通过id值来删除对应得用户记录
    public void delete(int id);
    //传入一个User对象，更新数据库中与此对应得记录
    public void update(T t);
    //通过id值获取一天数据记录
    public T getOne(int id);
}
