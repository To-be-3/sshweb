package cn.ljb.sshweb.web;

import cn.ljb.sshweb.model.User;
import cn.ljb.sshweb.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringConvertUser implements Converter<String, User> {

    @Autowired
    DepartmentService departmentService;
    @Override
    public User convert(String source) {
        //source:(id,username,password,dept_id)
        if(source!=null){
            String[] arr=source.split(",");
            User user=new User();
            user.setUsername(arr[0]);
            user.setPassword(arr[1]);
            user.setDepartment(departmentService.getOne(Integer.parseInt(arr[2])));
            return user;//完成类型转换之后返回User对象
        }
        return null;
    }
}
