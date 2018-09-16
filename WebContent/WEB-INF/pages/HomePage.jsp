<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="./css/c2.css" />     <!-- 导入css文件 --%>
<script type="text/javascript" src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>   <!-- JQuery库 -->
<script type="text/javascript" src="../js/json2.js"></script>       <!-- Json使用库 -->
<script type="text/javascript"></script>
</head>
<body>
<div id="wrap" class="wrap">	<!-- 顶层div -->
	<form:form action="userComment" method="post">
		<div id="header" class="header">	<!-- 抬头div -->
		</div>
		
		
		<div id="main-left" class="main-left">	<!-- 左侧空余div -->
		</div>
		
		
		<div id="main" class="main">	<!-- 中间主体div -->
		
			<div id="main_1" class="main_1">	<!-- 主体的内容部分div -->				  
  				<c:forEach items="${list}" var="obj"  varStatus="status">    				
  					<div id="main_1_1" class="main_1_1">    				
	     				<ul> 
		     		     	<li class="li1"><a href="#"><img src="${obj.psrc}"/></a></li>
		     				<li class="li2"><a href="#">${obj.pname}</a></li>
		     				<li class="li">上传者：${obj.userID}</li>
		     				<li class="li">照片背景：${obj.pstory}</li>	   
	     				</ul>   		      						      				
	      			</div>	      			      			                  		        
  				</c:forEach>    				
			</div>			
			<div id="main_2" class="main_2">	<!-- 下测分页、翻页提示div -->
			</div>
			
		</div>	<!-- 中间主体div -->
		
		
		<div id="main-rigth" class="main-rigth">	<!-- 右侧空余div -->
		</div>
		
		
		<div id="foot" class="foot">	<!-- 底部div -->
		</div>
	</form:form>
</div>	
</body>
</html>