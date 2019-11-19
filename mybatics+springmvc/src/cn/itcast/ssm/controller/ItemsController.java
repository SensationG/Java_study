package cn.itcast.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.exception.CustomException;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
import cn.itcast.ssm.validation.ValidGroup1;
import cn.itcast.ssm.validation.ValidGroup2;

//比如：商品列表：/items/queryItems.action
@Controller
//将来会有很多controller 例如items的，order的... 为了方便管理，
//在这里定义根路径@RequestMapping("/items")最终访问url是根路径+子路径
//比如 商品查询路径为： /items/queryItems.action
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService; //注入service

	//商品分类
	@ModelAttribute("itemtypes")
	public Map<String, String> getItemTypes(){
		
		Map<String, String> itemTypes = new HashMap<String,String>();
		itemTypes.put("101", "数码");
		itemTypes.put("102", "母婴");
		
		return itemTypes;
	}
	
	// 商品查询
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest httpServletRequest,ItemsQueryVo itemsQueryVo) throws Exception {
		
		System.out.println(	httpServletRequest.getParameter("id"));//检验forward转发可以请求request

		//获取jsp传输过来的包装类查询条件
		// 调用service查找 数据库，查询商品列表 
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);//传查询条件
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);
		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// 上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
	
	//商品信息修改页面显示
	//@RequestMapping("/editItems")
	//限制http请求方法为get和post
//	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView editItems() throws Exception {
//		
//		ItemsCustom itemsCustom = itemsService.findItemsById(1);//传入查询的id 这里先写死
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("itemsCustom", itemsCustom);
//		modelAndView.setViewName("items/editItems");
//		return modelAndView;
//	}
	//这是使用返回值为String的方法 替代上面的modelandview
	//@RequestParam是参数绑定的注解
	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
	public String editItems(Model model,@RequestParam(value="id")Integer id_term) throws Exception {
		ItemsCustom itemsCustom = itemsService.findItemsById(id_term);//传入查询的id，返回查询到的值
		//---自定义异常处理---判断商品是否为空，根据id没有查询到商品，抛出异常，提示用户信息不存在
//		if(itemsCustom==null){
//			throw new CustomException("商品不存在");
//		}
		//通过形参model将查询到的数据传到jsp
		model.addAttribute("itemsCustom", itemsCustom);//相当于modelAndView.addObject();方法
		return "items/editItems";//转发到页面
	}
	
	//商品信息修改提交 返回string类型
	//在需要校验的pojo前边添加@Validated，在需要校验的pojo后边添加BindingResult类接收校验出错信息
	//注意：@Validated（位置在前）和BindingResult（位置在后）是配对出现，且形参位置不能改变，一前一后
	//@Validated(value={ValidGroup1.class})指定使用ValueGroup1分组的校验
	@RequestMapping("/editItemsSubmit")//下面使用参数绑定 绑定pojo类型
	public String editItemsSubmit(Model model,Integer id,
			@Validated(value={ValidGroup1.class})ItemsCustom itemsCustom,BindingResult bindingResult) throws Exception {
		//获取错误信息
		if(bindingResult.hasErrors()){
			//输出错误信息 list接收
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for(ObjectError objectError:allErrors){
				System.out.println(objectError.getDefaultMessage());//在这打印检验是否校验器有效
			}
			model.addAttribute("allErrors",allErrors);
			return "items/editItems";//出错，重新回到商品修改页面
		}
		//在传入形参之前，使用了自定义参数绑定，将jsp的日期转为pojo所接受的date型
		itemsService.updateItems(id, itemsCustom);
		return "forward:queryItems.action";//forward转发到方法中
	}
//	//返回void类型
//	@RequestMapping("/editItemsSubmit2")
//	public void editItemsSubmit2(HttpServletRequest httpRequest,
//			HttpServletResponse httpResponse) throws Exception {
//		/*
//		 * 调用service更新商品信息，但页面需要将商品信息先传到此方法
//		 */
//		httpRequest.getRequestDispatcher("queryItems.action").forward(httpRequest, httpResponse);
//
//	}
	
	//商品删除
	@RequestMapping("/DeleteItems")
	public String DeleteItems(Integer[] items_id)throws Exception{		
		//调用service批量删除商品
		itemsService.deleteItems(items_id);
		return "redirect:queryItems.action";//删除完会跳删除成功页面
	}
	
	//批量修改商品页面（将商品信息查询出来，且在页面可以编辑）
	@RequestMapping("/editItemsquery")
	public String editItemsquery(Model model,ItemsQueryVo itemsQueryVo) throws Exception {
		//获取jsp传输过来的包装类查询条件，当首次开启页面没有输入查询条件时，mapper会判断，并返回all值
		// 调用service查找 数据库，查询商品列表 
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		model.addAttribute("itemsList",itemsList);
		return "items/editItemsQuery";
	}
	
	//批量修改商品提交
	//List参数绑定，通过ItemsQueryVo包装类接收批量提交的信息，存储到其中的itemsList属性
	@RequestMapping("/editItemsquerySubmit")
	public String editItemsquerySubmit(ItemsQueryVo itemsQueryVo) throws Exception {
		
		//调用service
		itemsService.EditupdateItems(itemsQueryVo);
		return "redirect:queryItems.action";
	}
	
	//新增商品信息
	@RequestMapping("/addItems")
	public String addItems() throws Exception {
		return "items/addItems";
	}
	
	//新增商品信息的提交
	//@ModelAttribute可以指定pojo回显到页面在request中的key
	@RequestMapping("/addItemsSubmit")
	public String addItemsSubmit(Model model,@ModelAttribute("item")@Validated(value={ValidGroup2.class})
			ItemsCustom itemsCustom,BindingResult bindingResult) throws Exception {
		//获取错误信息
		if(bindingResult.hasErrors()){
			//输出错误信息 list接收
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			//自动回显
			model.addAttribute("allErrors",allErrors);
			return "items/addItems";//出错，重新回到商品修改页面
		}
		float a = (float)0.0 ;
		if(itemsCustom.getPrice()<a){
			throw new CustomException("价格不能小于0");
		}
		itemsService.addItem(itemsCustom);
		return "redirect:queryItems.action";
	}
	
	//查询商品信息，输出json 使用RESTful规范
	///RESTJson/{id}里边的{id}表示将这个位置的参数传到@PathVariable指定名称中
	//在这里@PathVariable指定的名称是括号里的id，只有这么定义，jsp传过来的参数才会绑定在形参里，但形参的名称不用和PathVariable的一致
	@RequestMapping("/RESTJson/{id}")
	public @ResponseBody ItemsCustom RESTJson(@PathVariable("id") Integer id)throws Exception{
		//请求的时key/value 所以不需要转换格式
		ItemsCustom itemsCustom = itemsService.findItemsById(id);//传入查询的id，返回查询到的值
		//使用注解@ResponseBody将return回的pojo对象转成json 再传回去
		return itemsCustom;
	}
	
}
