<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Json交互测试</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript">
    //提交json，输出的是json 
    //使用ajax传输数据 ajax用于js发请求，收响应
    	function requestJson(){
    		$.ajax({
    			type:'post',
    			url:'${pageContext.request.contextPath }/requestJson.action',
    			contentType:'application/json;charset=utf-8',
    			//数据格式是json串
    			data:'{"name":"手机","price":999}',
    			success:function(data){//返回json结果
    				alert(data);
    			}
    		});
    	}
    	
    	
    //提交的是key/value，输出json
    	function responseJson(){
    		$.ajax({
    			type:'post',
    			url:'${pageContext.request.contextPath }/responseJson.action',
    			//提交key/value，不需要contenttype
    			//contentType:'application/json;charset=utf-8',
    			data:'name=手机&price=999',
    			success:function(data){//返回json结果
    				alert(data.name);
    			}
    		});
    	}
    </script>

  </head>
  
  <body>
   	<input type="button" onclick="requestJson()" value="请求json，输出json">
   	<input type="button" onclick="responseJson()" value="请求的是key/value，输出json">
  </body>
</html>
