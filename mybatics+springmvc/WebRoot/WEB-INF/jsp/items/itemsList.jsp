<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查询商品列表</title>
	<script type="text/javascript">
	function deleteItems(){
		document.itemsForm.action="${pageContext.request.contextPath }/items/DeleteItems.action";
		document.itemsForm.submit();
	}
	function queryItems(){
		document.itemsForm.action="${pageContext.request.contextPath }/items/queryItems.action";
		document.itemsForm.submit();
	}
	function EditItems(){
		document.itemsForm.action="${pageContext.request.contextPath }/items/editItemsquery.action";
		document.itemsForm.submit();
	}
	function addItems(){
		document.itemsForm.action="${pageContext.request.contextPath }/items/addItems.action";
		document.itemsForm.submit();
	}
	</script>
</head>
<body> 
当前用户：${username } <!-- 直接从session取 -->
<c:if test="${username!=null }">
	<a href="${pageContext.request.contextPath }/logout.action">退出</a>
</c:if>
	<form name="itemsForm"  method="post">
	查询条件：
	<table width="100%" border=1>
		<tr>
			<td>商品名称查询：
				<input type="text" name="itemsCustom.name"/><!-- itemsCustom.name为包装类的属性，name为属性中的属性 -->
				<input type="button" value="查询" onclick="queryItems()"/><!-- 表单分向提交 -->
			</td>
			<td>商品类型:
				<select name="itemtype">
					<c:forEach items="${itemtypes }" var="itemtype">
						<option value="${itemtype.key }">${itemtype.value }</option>		
					</c:forEach>
				</select>	
			</td>
			<td>
				<input type="button" value="批量删除" onclick="deleteItems()"/>
				<input type="button" value="批量修改" onclick="EditItems()"/>
				<input type="button" value="新增商品" onclick="addItems()"/>
			</td>	
		</tr>
	</table>
	商品列表：
	<table width="100%" border=1>
		<tr>
			<td>选择</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>生产日期</td>
			<td>商品描述</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${itemsList }" var="item">
		<tr><!-- checkbox的name要和controller形参的属性名一样 由于上面是foreach 所以传回去就是多个值-->
			<td><input type="checkbox" name="items_id" value="${item.id}"/></td><!-- 当勾选时，就会把value的值提交，这里填商品id -->
			<td>${item.name }</td>
			<td>${item.price }</td>
			<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td>${item.detail }</td>
			
			<td><a href="${pageContext.request.contextPath }/items/editItems.action?id=${item.id}">修改</a></td>
		</tr>
		</c:forEach>

	</table>
	</form>
</body>

</html>