package cn.ljb.sshweb.dao;

import cn.ljb.sshweb.model.Department;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDao<Department> implements DepartmentDao {
    @Override
    public List<Department> getAll() {
        String hql="from Department";
        Session session=getSession();
        Query<Department> query=session.createQuery(hql);
        return query.list();
    }
}
