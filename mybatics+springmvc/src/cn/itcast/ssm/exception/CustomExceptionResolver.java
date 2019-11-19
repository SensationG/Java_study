package cn.itcast.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/*
 * 
 * 自定义全局异常处理器
 * 实现HandlerExceptionResolver接口
 * 
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	//其本质是一个method（handler）用法也与handler相同
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
//		//handler就是处理器适配器要执行的Handler对象
//		//解析出异常类型
//		//如果该异常类型是系统自定义异常，直接取出异常信息，在错误页面提示
//		String message = null;
//		//instanceof:左面的对象是右面的类创建的对象时,该运算符运算的结果是true,否则是false
//		if(ex instanceof CustomException){
//			message = ((CustomException)ex).getMessage();将Exception类强转为CustomException类
//		}else {
//			message="未知错误";
//		}
	
		//上面代码变为:
		CustomException customException = null;//new一个空的对象
		if(ex instanceof CustomException){//判断controller传进来的异常是否符合系统的异常
			//instanceof:左面的对象是右面的类创建的对象时,该运算符运算的结果是true,否则是false
			//因为customException是继承Exception的所以可以强转
			customException = ((CustomException)ex);//将Exception类强转为CustomException类
		}else {
			customException = new CustomException("未知错误");//新构造一个
		}
		
		//错误信息
		String message = customException.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message",message);
		modelAndView.setViewName("error");
		return modelAndView;
	}
	
}
