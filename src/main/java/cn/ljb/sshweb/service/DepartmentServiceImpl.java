package cn.ljb.sshweb.service;

import cn.ljb.sshweb.dao.DepartmentDao;
import cn.ljb.sshweb.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service("departmentService")
public class DepartmentServiceImpl extends BaseService<Department> implements DepartmentService {
    public DepartmentServiceImpl() {
        System.out.println("================================DepartmentServiceImpl被加载到IOC容器");
    }

    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public List<Department> getAllDepartments() {
        return departmentDao.getAll();
    }
}
