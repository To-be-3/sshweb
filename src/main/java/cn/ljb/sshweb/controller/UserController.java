package cn.ljb.sshweb.controller;

import cn.ljb.sshweb.model.Department;
import cn.ljb.sshweb.model.User;
import cn.ljb.sshweb.service.DepartmentService;
import cn.ljb.sshweb.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@Controller
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/testex")
    public String testex(int i){
        System.out.println(10/i);
        return "redirect:/";
    }

    /**
     * 1.这个方法只能处理本 Contro1ler类中出的异常
     * 2.这个方法出异常会跳转到 error,jsp页面,我们如果想把异常信息,注入到jsp页面,用 Modle不好使!
     * 3.显然,在本类中,我们可以定义多个这样的异常处理方法,那么最终那个方法起作用,看异常域那个方法拦献的异常接近
    *//*@ExceptionHandler({ArithmeticException.class})
    public String handlerArithmeticException1(Exception ex){
        System.out.println("=====出了异常！"+ex);
        return "error";
    }*//*
    //如果想把异常信息,注入到jsp页面,用 Modle作为入参不好使，那就要使用以下这种方式：
    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handlerArithmeticException2(Exception ex){
        System.out.println("=====出了异常！"+ex);
        ModelAndView modelAndView=new ModelAndView("error");
        modelAndView.addObject("exception",ex.getMessage());
        return modelAndView;
    }*/

    //文件的下载
    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename) throws Exception {
        //通过request对象拿到下载文件的绝对路径：
        // D:\\apache-tomcat-8.5.47\\apache-tomcat-8.5.47\\webapps\\sshweb_war\\resources\\uploadfiles
        //String path=request.getServletContext().getRealPath("/resources/uploadfiles");
        String path="D:\\IdeaProjects\\sshweb\\src\\main\\webapp\\WEB-INF\\resources\\uploadfiles";
        File file=new File(path,filename);
        HttpHeaders headers=new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFileName=new String(filename.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式,附件）打开文件
        headers.setContentDispositionFormData("attachment",downloadFileName);
        //application/octet-stream:二进制流数据（最常见的文件下载）
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                                            headers, HttpStatus.CREATED);
    }

    //文件的上传
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestParam("mark") String mark,
                         @RequestParam("file") MultipartFile file,
                         HttpServletRequest request) throws IOException {
        if(!file.isEmpty()){
            //拿到保存文件的绝对路径:D:\\apache-tomcat-8.5.47\\apache-tomcat-8.5.47\\webapps\\sshweb_war\\resources\\uploadfiles
//            String path=request.getServletContext().getRealPath("/resources/uploadfiles");
            //拿到被传上来的文件的原文件名
            String path="D:\\IdeaProjects\\sshweb\\src\\main\\webapp\\WEB-INF\\resources\\uploadfiles";
            String filename=file.getOriginalFilename();
            File file1=new File(path,filename);
            if(!file1.getParentFile().exists()){//判断存放文件的目录是否存在
                file1.getParentFile().mkdirs();
            }
            file.transferTo(file1);//将上传的文件转成目标文件，写进硬盘了
        }
        return "redirect:/";
    }



    @ResponseBody
    @RequestMapping(value = "/testConvert",method = RequestMethod.POST)
    public String testConvert(@RequestBody String test){//接受从浏览器的请求
        System.out.println(test);
        return "asdfghjklasdfghjklsdfghjk"+new Date();//跟视图没有关系，把这些字符直接响应给浏览器显示，不经过视图解析器,
                                                      //所以必须加@ResponseBody这个注解
    }

    //=================返回json格式传统方式
    @RequestMapping(value = "/testJson1",method = RequestMethod.POST)
    public void testJson1(HttpServletResponse response, PrintWriter writer) throws JsonProcessingException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
        List<User> users=userService.getAllUsers();
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(users);
        System.out.println("=====json格式的所有用户信息: "+json);
        writer.print(json);//向浏览器响应json格式数据

    }
    //================springmvc的傻瓜方式
    /**
     * 在 SpringMVO的 Controller层经常会用到@RequestBody和@ResponseBody,
     * 通过这两个注解,可以在 Controller中直接使用Java对象作为请求参数和返回内容
     * (这里直接将返回内容直接写入到 Response对象的bod数据区,从而绕过来前面我们讲的视图解析器,
     * 不通过视图解析器直接将数据响应给浏览器),而在写入之前必须要转换响应的数据格式,完成这之间转换作用的便是 Httpmessage Converter.
     */
    @ResponseBody
    @RequestMapping(value = "/testJson2",method = RequestMethod.POST)
    public List<User> testJson2(){
        return userService.getAllUsers();
    }
    @RequestMapping("/jsonTestView")
    public String jsonTestView(){
        return "jsonTestView";
    }


    @RequestMapping(value = "/convertUser",method = RequestMethod.POST)
    public String convertUser(User user){
        System.out.println("这里是用了我们自己定义的类型转换器转换出的User对象: "+user);
        userService.add(user);
        return "redirect:/users";
    }

    /**
     * rest风格：
     * URL：xxx/users     Get方法，获取所有users
     *
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    /**
     * rest风格：
     * URL：xxx/user/{id}     Get方法，更新一条user记录（填表单）
     *
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String updateUserView(@PathVariable("id") Integer id, Model model) {
        if (id != null) {
            User user = userService.getOne(id);
            model.addAttribute("user", user);
        }
        List<Department> depts = departmentService.getAllDepartments();
        model.addAttribute("depts", depts);
        return "updateUserView";
    }

    /**
     * rest风格：
     * URL：xxx/user     put方法，更新一条数据到数据库
     *
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(User user) {
        //有一个问题需要我们来解决，解决完了我们才能够真正的调用userService的方法去修改，
        // 因为此时username=null，deptName=null，用@ModelAttribute
//        userService.update(user);
        userService.update(user);
        return "redirect:/users";
    }

    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id,
                        @RequestParam(value = "department.id", required = false) Integer dept_id,
                        Model model) {
        if (id != null && dept_id != null) {
            User user = userService.getOne(id);
            Department department = departmentService.getOne(dept_id);
            user.setDepartment(department);
            model.addAttribute("user", user);
        }
    }

    /**
     * rest风格：
     * URL：xxx/user    get方法，新添一个用户（填表单）
     *
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String addUserView(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("depts", departmentService.getAllDepartments());
        return "addUserView";
    }

    /**
     * rest风格：
     * URL：xxx/user    post方法，新添一个用户到数据库
     *
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@Valid User user, Errors errors,Model model) {
        if(errors.getErrorCount()>0){
            System.out.println("某些数据不符合数据有效性校验");
            for (FieldError fe:errors.getFieldErrors()) {
                System.out.println("====="+fe.getField()+":"+fe.getDefaultMessage()+"=====");
            }
            model.addAttribute("depts", departmentService.getAllDepartments());
            return "addUserView";
        }
        userService.add(user);
        return "redirect:/users";
    }

    /**
     * rest风格：
     * URL：xxx/user/{id}    delete，从数据库中删除一个用户
     *
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable(value = "id", required = false) Integer id) {
        if (id != null) {
            userService.delete(id);
        }
        return "redirect:/users";
    }


    @RequestMapping(value = {"/","/index"})
    public String indexTest() {
        return "index";
    }


}
