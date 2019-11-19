package cn.itcast.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import cn.itcast.ssm.po.Items;

//实现HttpRequestHandler接口的处理器（即这是Handler处理器）
public class ItemsController2 implements HttpRequestHandler{
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		
		//设置模型数据
		request.setAttribute("itemsList",itemsList);
		//转发
		request.getRequestDispatcher("/WEB-INF/jsp/items/itemsList.jsp").forward(request, response);
		
		//通过此方法可以修改response，设置响应的数据格式，比如json数据
		//		response.setCharacterEncoding("utf-8");
		//		response.setContentType("application/json;charset=utf-8");
		//		response.getWriter().write("json串");

	}
}
