package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.exception.CustomException;
import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;

/*
 * 
 * Service
 * 商品管理
 * 
 */
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;//注入mapper
	
	@Autowired
	private ItemsMapper itemsMapper;//注入逆向工程的mapper
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		//通过ItemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override //根据id查询商品信息
	public ItemsCustom findItemsById(Integer id) throws Exception {	
		//查询
		Items items = itemsMapper.selectByPrimaryKey(id);
		//也可以在service抛出异常，它将交给上层去处理
		if(items==null){
			throw new CustomException("商品不存在");
		}
		/*
		 * 事务处理 （例如判断商品生产日期是否到期，给予标注）
		 * 这里还没有使用处理 故省略
		 */
		//这里写null 是因为异常处理时controller判断异常的依据是对象为空，如果不为null，会造成对象不为空属性为空的误判
		ItemsCustom itemsCustom = null;	//使用扩展类 方便事务处理时候添加标记等
		if(items!=null){
			itemsCustom = new ItemsCustom();//如果不为空，再new，只有在查询到数据时，再new，保证属性不为空
			BeanUtils.copyProperties(items, itemsCustom);	//将items的值拷贝到扩展类
		}
		return itemsCustom;
	}

	@Override //根据id修改商品信息
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		//优化 添加业务校验（对关键参数进行校验 ）
		//对 id 进行校验，如果为空，抛出异常 但是int类型无法判断是否为空，所以使用intege类型 ---这里先不校验 后面再写
		
		//使用updateByPrimaryKeyWithBLOBs根据id更新items表中的所有字段，包括大文本txt类型字段都可以更新
		//updateByPrimaryKeyWithBLOBs要求必须传入id
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);//这里直接逆向工程自动生成的方法
	}

	
	@Override//根据数组id删除商品
	public void deleteItems(Integer[] id) throws Exception {
		for(Integer i:id){
			itemsMapper.deleteByPrimaryKey(i);
		}
	}

	@Override//批量修改商品
	public void EditupdateItems(ItemsQueryVo itemsQueryVo) throws Exception {
		//遍历list修改
		List<ItemsCustom> list = itemsQueryVo.getItemsList();
		for(ItemsCustom items:list){
			itemsMapper.updateByPrimaryKeyWithBLOBs(items);
		}
		
	}

	@Override
	public void addItem(ItemsCustom itemsCustom) throws Exception {
		itemsMapper.insert(itemsCustom);
	}
	
	
	
}
