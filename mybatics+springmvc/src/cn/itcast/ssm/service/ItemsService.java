package cn.itcast.ssm.service;

import java.util.List;

import org.omg.CORBA.INTERNAL;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
/*
 * 
 * 商品管理Service
 * 
 */
public interface ItemsService {
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//根据id查询商品信息 为了页面的可扩展性 要用item的扩展类ItemsCustom
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	//修改商品信息(不需要返回值) 需要传入商品id 和 要修改的商品信息（虽然包括id，但方便开发和维护，把id提取出来，用来表示必须传这个id）
	public void updateItems(Integer id,ItemsCustom itemsCustom)throws Exception;
	
	//删除商品
	public void deleteItems(Integer[] id)throws Exception;
	
	//批量修改商品
	public void EditupdateItems(ItemsQueryVo ItemsQueryVo)throws Exception;
	
	//新增商品
	public void addItem(ItemsCustom itemsCustom)throws Exception;
}
