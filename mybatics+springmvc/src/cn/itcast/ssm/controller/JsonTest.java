package cn.itcast.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.ssm.po.ItemsCustom;
/*
 * 
 * json交互测试controller
 * 
 */
@Controller
public class JsonTest {
	
	//传入json，输出响应json
	//要将jsp传来的json串转成pojo对象itemscustom,再将转成的pojo对象转成json return回去
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemscustom){
		//使用注解@RequestBody将jsp传过来的json串转成pojo对象
		//使用注解@ResponseBody将return回的pojo对象转成json 再传回去
		return itemscustom;
	}
	
	//传入key/value，输出响应json
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemscustom){
		//请求的时key/value 所以不需要转换格式
		//使用注解@ResponseBody将return回的pojo对象转成json 再传回去
		return itemscustom;
	}
}
