package cn.ljb.sshweb.service;

import cn.ljb.sshweb.model.Department;

import java.util.List;

public interface DepartmentService extends BaseServiceI<Department> {

    public List<Department> getAllDepartments();
}
