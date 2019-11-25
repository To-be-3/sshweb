package cn.ljb.sshweb.controller;

import cn.ljb.sshweb.model.Department;
import cn.ljb.sshweb.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    public String getDepts(Model model){
        model.addAttribute("depts",(List<Department>)(departmentService.getAllDepartments()));
        return "depts";
    }
    @RequestMapping(value = "/dept",method = RequestMethod.GET)
    public String addDeptView(Model model){
        model.addAttribute("dept",new Department());
        return "addDeptView";
    }
    @RequestMapping(value = "/dept",method = RequestMethod.POST)
    public String addDept(@Valid Department department, Errors errors,Model model){
        if (errors.getErrorCount() > 0) {
            System.out.println("某些数据不符合数据有效性校验");
            for (FieldError fe:errors.getFieldErrors()) {
                System.out.println("====="+fe.getField()+":"+fe.getDefaultMessage()+"=====");
            }
            return "addUserView";
        }
        departmentService.add(department);
        return "redirect:/depts";
    }
    @RequestMapping(value = "/dept/{id}",method = RequestMethod.DELETE)
    public String deleteDept(@PathVariable(value = "id",required = false)Integer id){
        if(id!=null){
            departmentService.delete(id);
        }
        return "redirect:/depts";
    }
    @RequestMapping(value = "/dept/{id}",method = RequestMethod.GET)
    public String updateDeptView(@PathVariable(value = "id",required = false)Integer id,Model model){
        if(id!=null){
            model.addAttribute("dept",departmentService.getOne(id));
        }
        return "updateDeptView";
    }
    @RequestMapping(value = "/dept",method = RequestMethod.PUT)
    public String updateDept(Department department){
        departmentService.update(department);
        return "redirect:/depts";
    }

}
