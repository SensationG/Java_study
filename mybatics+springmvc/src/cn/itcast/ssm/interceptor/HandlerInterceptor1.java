package cn.itcast.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * 
 * 测试拦截器1 实现HandlerInterceptor接口
 * 
 * 
 */
public class HandlerInterceptor1 implements HandlerInterceptor{

	//执行controller完成之后执行此方法
	//统一异常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("HandlerInterceptor1--afterCompletion");
	}

	//进入Controller方法后，在返回modelandview之前执行
	//应用场景从modelAndView出发：将公用的模型数据（比如菜单的导航）在这里传到视图，也可以在这里统一指定视图
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		
		System.out.println("HandlerInterceptor1--postHandle");
	}

	//进入Controller方法之前执行
	//用于身份认证，身份授权（登陆）
	//比如身份认证不通过，表示当前用户没有登陆，需要此方法拦截不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		System.out.println("HandlerInterceptor1--preHandle");
		
		//return false 表示拦截，不向下执行
		//return true 表示放行
		return true;
	}

}
