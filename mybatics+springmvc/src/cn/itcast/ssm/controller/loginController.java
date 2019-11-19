package cn.itcast.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.ssm.po.ItemsCustom;
//登陆认证controller
@Controller
public class loginController {
	//登陆
	@RequestMapping("/login")
	public String login(HttpSession session,String username,String password)throws Exception{
		//session直接定义形参可以用
		//调用service。将形参传过来的session进行用户身份认证....这里省略
		//如果验证通过，在session中设置用户名信息，在session中保存用户身份信息
		session.setAttribute("username", username);
		//重定向到商品列表页面
		return "redirect:items/queryItems.action";
	}
	//登出
	@RequestMapping("/logout")
	public String loginout(HttpSession session)throws Exception{
		//session直接定义形参可以用
		//调用service进行用户身份认证....这里省略这里使用硬编码校验
		//清楚session
		session.invalidate();
		//重定向到商品列表页面
		return "redirect:/items/queryItems.action";
	}
}
