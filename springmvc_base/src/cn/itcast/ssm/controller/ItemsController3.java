package cn.itcast.ssm.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.Items;
/*
 * 注解的Handler
 * 
 */
//使用注解@Controller来标识 它是一个控制器
@Controller
public class ItemsController3 {
	//商品查询列表
	//一般建议将url和方法名写成一样方便维护，但url与方法名没有任何关系，一个方法一个url
	@RequestMapping("/QueryItems4")//方法的url映射注解
	public ModelAndView QueryItems() throws Exception{
		//调用service查找数据库，查询商品列表，这里使用静态数据模拟,后面整合后再用mybatis
		List<Items> itemsList = new ArrayList<Items>();
		//请求模型进行处理--》pojo
		//向list中填充静态数据
		Items item_1 = new Items();
		item_1.setName("联想笔记本");
		item_1.setPrice(6000f);
		item_1.setDetail("ThinkPad T430联想笔记本");
		
		Items item_2 = new Items();
		item_2.setName("苹果手机");
		item_2.setPrice(5000f);
		item_2.setDetail("iphone6苹果手机");
		
		itemsList.add(item_1);
		itemsList.add(item_2);	
		
		//处理结果返回-》返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		//相当于request的setAttribute，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);
		//指定视图(指定数据传入的jsp页面)
		//modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		//上边的路径 如果在前端控制器的视图解析器中有配置前缀和后缀 那么只需要写为
		modelAndView.setViewName("items/itemsList");
		
		return modelAndView;
	}
	//下面可以定义其他方法 使用注解
}
