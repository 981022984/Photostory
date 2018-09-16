<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,inital-scale=1,maximum-scale=1,user-scalable=no;"/>
<title>登录</title>
<link rel="stylesheet" type="text/css" href="./css/c1.css" />     <%-- 导入css文件 --%>
<script type="text/javascript">
	function setvalue1(x)
	{
		var t=document.getElementById(x);
		if(t.value=="输入账号")
			t.value=""
		else if(t.value=="")
			t.value="输入账号"
	}
	function setvalue2(x1)
	{
		var t1=document.getElementById(x1);   //明文框
		var t2=document.getElementById("password");  //密码框 
		t1.style.visibility="hidden";         //visibility设置元素是否可见
		t2.focus();
	} 
	function setvalue3(x1)
	{
		var t1=document.getElementById(x1);
		var t2=document.getElementById("password2");
		if(t1.value=="")
			t2.style.visibility="visible";
	}
</script>
</head>
<body class="body">
	<div class="base">
	
	<form:form commandName="User" action="validateLogin" method="POST">
	<div class="head">  <%-- 头 --%>
		
	</div>
	
	<div class="two">
		<div class="three">
			<p class="p1">登录</p>
		</div>
		<div>
			<form:input class="five" type="text" name="userID" id="userID" path="userID"
				value="输入账号" onfocus="setvalue1(this.id)" onblur="setvalue1(this.id)"/>
			<br/>
			<form:input class="six" type="password" tabindex="-1" name="password" 
				id="password"  path="userPassword" onblur="setvalue3(this.id)"/>
			<input class="six" type="text" name="password2" id="password2" value="输入密码" onfocus="setvalue2(this.id)"/>
			<br/>
			<input class="serven" type="submit" name="bt1" id="bt1" value="登录"/>
		</div>
	</div>
	
	<div class="fotter" id="foot">  <%-- 尾 --%>
		<div class="copyright">
    		<p>Copyright © 2018 Zuo Shufan. All Rights Reserved.</p>
    		
    		<div class="img">
				<i class="icon"></i><span>联系邮箱：981022984@qq.com</span>
			</div>
	
			<div class="img">
				<i class="icon1"></i><span>联系地址：湖南理工学院</span>
			</div>
	  
			<div class="img">
	  			<i class="icon2"></i><span>联系电话：13617304487</span>
			</div>
 		</div>
	</div>
	</form:form>
	</div>
</body>
</html>