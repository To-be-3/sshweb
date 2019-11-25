package cn.ljb.sshweb.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 专门处理异常的Controller类
 */
//@ControllerAdvice        //还有另外一种更加常用的方法，具体看springmvc.xml里的配置第87行
                          // <bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
public class ExController {
    /**
     * 1.这个方法只能处理本 Contro1ler类中出的异常
     * 2.这个方法出异常会跳转到 error,jsp页面,我们如果想把异常信息,注入到jsp页面,用 Modle不好使!
     * 3.显然,在本类中,我们可以定义多个这样的异常处理方法,那么最终那个方法起作用,看异常域那个方法拦献的异常接近
     */
    /*@ExceptionHandler({ArithmeticException.class})
    public String handlerArithmeticException1(Exception ex){
        System.out.println("=====出了异常！"+ex);
        return "error";
    }*/
    //如果想把异常信息,注入到jsp页面,用 Modle作为入参不好使，那就要使用以下这种方式：
    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handlerArithmeticException2(Exception ex){
        System.out.println("=====出了异常！"+ex);
        ModelAndView modelAndView=new ModelAndView("error");
        modelAndView.addObject("exception",ex.getMessage());
        return modelAndView;
    }

    @ExceptionHandler({RuntimeException.class})
    public ModelAndView runtimeException(Exception ex){
        System.out.println("=====出了异常！"+ex);
        ModelAndView modelAndView=new ModelAndView("error");
        modelAndView.addObject("exception",ex.getMessage());
        return modelAndView;
    }
}
