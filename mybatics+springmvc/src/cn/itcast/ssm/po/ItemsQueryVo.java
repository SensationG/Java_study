package cn.itcast.ssm.po;

import java.util.List;

import javax.validation.Valid;

/*
 * 用于输入映射
 * pojo包装类
 * 包装了查询条件
 */
public class ItemsQueryVo {
	
	//商品信息
	private Items items;
	//为了系统 可扩展性，对原始生成的po进行扩展
	@Valid
	private ItemsCustom itemsCustom;
	//批量商品的接受List<pojo>类 属性
	private List<ItemsCustom> itemsList;
	

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}

	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}


	
	

}
