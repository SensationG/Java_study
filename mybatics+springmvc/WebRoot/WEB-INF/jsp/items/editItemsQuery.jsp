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
	function editItemsQuerySubmit(){
		document.itemsForm.action="${pageContext.request.contextPath }/items/editItemsquerySubmit.action";
		document.itemsForm.submit();
	}
	function queryItems(){
		document.itemsForm.action="${pageContext.request.contextPath }/items/queryItems.action";
		document.itemsForm.submit();
	}
	</script>
</head>
<body> 
	<form name="itemsForm"  method="post">
	查询条件：
	<table width="100%" border=1>
		<tr>
			<td>商品名称查询：
				<input type="text" name="itemsCustom.name"/><!-- itemsCustom为包装类的属性，name为属性中的属性 -->
				<input type="button" value="查询" onclick="queryItems()"/><!-- 表单分向提交 -->
			</td>
			<td>
				<input type="button" value="批量修改提交" onclick="editItemsQuerySubmit()"/>
			</td>	
		</tr>
	</table>
	商品列表：
	<table width="100%" border=1>
		<tr>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>生产日期</td>
			<td>商品描述</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${itemsList }" var="item" varStatus="status"><!--status为迭代计数器-->
		<tr><!-- 商品输入框改成可编辑模式 itemsList是一个list，所以需要下标-->
			<!-- status.index为迭代器 index表示从0开始计数 count表示从1开始计数 -->
			<input type="hidden" name="itemsList[${status.index }].id" value="${item.id }"/>
			<td><input name="itemsList[${status.index }].name" value="${item.name }"/> </td>
			<td><input name="itemsList[${status.index }].price" value="${item.price }"/></td>
			<td><input name="itemsList[${status.index }].createtime" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
			<td><input name="itemsList[${status.index }].detail" value="${item.detail }"/></td>	
		</tr>
		</c:forEach>

	</table>
	</form>
</body>

</html>