package cn.ljb.sshweb.controller;

import cn.ljb.sshweb.web.MyDoubleEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {
    /**
     * WebData Binder是用来绑定请求参数到指定的属性编辑器由于前台传到 controller里的值是String类型的,
     * 当往Mode里set这个值的时候,如果set的这个属性是个对象, Spring就会去找到对应的 editor进行转换,
     * 然后再Set进去.
     * @param binder
     */
    //SpringMVC支持用注解代替@ initBinder注解及方法:具体看model类User
    @InitBinder
    protected void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        // setlenient用于设置 Calendar是否宽松解析字符串,如果为 false,则严格解析,默认为true,宽松解析
        // 宽松解析字符串:输入"33/12/2011",用 SimpleDate Format parse()方法,转化为Date(2012,01,02)
        //严格解析:会把"33/12/2011"当作错误格式
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,true));

//        binder.registerCustomEditor(Double.class,new CustomNumberEditor(Double.class,true));
        //使用自定义编辑器
        binder.registerCustomEditor(Double.class,new MyDoubleEditor());
    }
}
