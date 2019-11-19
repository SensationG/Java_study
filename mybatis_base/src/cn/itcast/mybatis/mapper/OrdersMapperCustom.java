package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;



public interface OrdersMapperCustom {
	
	//查询订单关联查询用户
	public List<OrdersCustom> findOrderUser() throws Exception;
	//查询订单关联查询用户使用resultMap
	public List<Orders> findOrderUserResultMap() throws Exception;
	
}
