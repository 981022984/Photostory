<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>PhotoStory</title>

	<!-- Le styles -->
	<link href="./layoutit/bootstrap-combined.min.css" rel="stylesheet">
	<link href="./layoutit/layoutit.css" rel="stylesheet">
	<link href="./layoutit/h5.css" rel="stylesheet">
	<link href="./css/bootstrap.min.css" rel="stylesheet">


	<!-- Fav and touch icons -->
	<link rel="shortcut icon" href="img/favicon.png">
	<script type="text/javascript" src="./js/json2.js"></script>
	<script type="text/javascript" src="./js/jquery-3.1.1.min.js"></script>
	
	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
		<script src="./layoutit/html5shiv.js"></script>
	<![endif]-->
	
	<script type="text/javascript" src="./layoutit/bootstrap.min.js"></script>
	<script type="text/javascript" src="./layoutit/jquery-ui.js"></script>
	<script type="text/javascript" src="./layoutit/jquery.ui.touch-punch.min.js"></script>
	<script type="text/javascript" src="./layoutit/jquery.htmlClean.js"></script>
	<script type="text/javascript" src="./layoutit/ckeditor/ckeditor.js"></script><style>.cke{visibility:hidden;}</style>
	<script type="text/javascript" src="./layoutit/ckeditor/config.js"></script>
	<script type="text/javascript" src="./layoutit/scripts.js"></script>
	<script type="text/javascript" src="http://www.bootcss.com/p/layoutit/ckeditor/config.js?t=D3NA"></script><link rel="stylesheet" type="text/css" href="http://www.bootcss.com/p/layoutit/ckeditor/skins/moono/editor.css?t=D3NA"><script type="text/javascript" src="http://www.bootcss.com/p/layoutit/ckeditor/lang/zh-cn.js?t=D3NA"></script><script type="text/javascript" src="http://www.bootcss.com/p/layoutit/ckeditor/styles.js?t=D3NA"></script>
	
	<!-- 网络包 -->
	<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> -->
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
   	<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>
<body>
	
	
	<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<div class="container-fluid">
						<a class="btn btn-navbar" data-target=".navbar-responsive-collapse" data-toggle="collapse"></a> 
						<em><a class="brand" href="/PhotoStory/dealwithPhotos">PhotoStory</a></em>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span4">
			<p>
				<img alt="" src="./image/p5.jpg" />
			</p>
		</div>
		<div class="span8">
			<div class="row-fluid">
				<div class="span4">
				</div>
				<div class="span8">
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>

					<form:form commandName="User" action="newUser" method="POST">
						<fieldset><legend ><span style="font-size: 26.5px; font-weight: bold;">欢迎注册<em>PhotoStory</em></span>
						<br>身边的美丽，在你我分享！<br>
						<span style="font-size: 18px;">用户名</span><br>
							<form:input path="userID" placeholder="userID" style="width:420px;height:40px;" type="text"/>
							<form:errors path="userID" cssStyle="color:red"/>
							<span style="font-size: 18px;"></span><br>
						<span style="font-size: 18px;">密码</span><br>
							<form:input path="userPassword" placeholder="password" style="width:420px;height:40px;" type="password"/>
							<form:errors path="userPassword" cssStyle="color:red"/>
							<br>
						<span style="font-size:18px;">确认密码</span><br>
							<input name="password" placeholder="password" style="width:420px;height:40px;" type="password"> 
						<label class="checkbox" ><input type="checkbox" checked> 直接登录 </label> <br>
						<button id="submit" class="btn btn-primary"  style="width:430px;height:50px;" type="submit">提交</button>
						</legend></fieldset>
					</form:form>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>	
				</div>
			</div>
		</div>
	</div>
</div>

	
</body>
</html>