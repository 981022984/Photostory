<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<script src="https://cdn.bootcss.com/html5shiv/r29/html5.js"></script>
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
	<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
   	<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/4.1.1/js/bootstrap.min.js"></script> -->
</head>
<body>
	
	<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<div class="container-fluid">
						<a class="btn btn-navbar" data-target=".navbar-responsive-collapse" data-toggle="collapse"></a> <em><a class="brand" href="#">PhotoStory</a></em>
						<div class="nav-collapse collapse navbar-responsive-collapse">
						</div>
						
					</div>
				</div>
				
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span3">
			<div id="select" class="hero-unit well">
				<h3>
					Hello, world!
				</h3>
				<p>
					<a id="p" class="btn btn-primary btn-large" href="#UserPhotos">我的图片</a>
				</p>
				<p>
					<a id="p" class="btn btn-primary btn-large" href="#UserNews">我的消息</a>
				</p>
				<p>
					<a id="p" class="btn btn-primary btn-large" href="#ChangePassword">修改密码</a>
				</p>
				<p>
					<a id="p" class="btn btn-primary btn-large" href="#ChangeUserName">修改昵称</a>
				</p>
				<p>
					<a id="p" class="btn btn-primary btn-large" href="#UploadPhotos">上传图片</a>
				</p>
				<p>
					<a class="btn btn-primary btn-large" href="/PhotoStory/dealwithPhotos">返回首页</a>
				</p>
			</div>
		</div>
		<div class="span9">
		
			<!-- 修改密码  -->
			<div id="ChangePassword" style="display:none;">
				<form class="form-horizontal">
					<div class="control-group"><label class="control-label" for="inputEmail">旧密码</label>					
						<div class="controls"><input id="inputEmail" style="width:320px;height:40px;" placeholder="Old Password" type="password" /></div>
					</div>
					
					<div class="control-group"><label class="control-label" for="inputPassword">新密码</label>					
						<div class="controls"><input id="inputPassword" style="width:320px;height:40px;" placeholder="New Password" type="password" /></div>
					</div>
					
					<div class="control-group"><label class="control-label" for="inputPassword">确认密码</label>					
						<div class="controls"><input id="inputPassword" style="width:320px;height:40px;" placeholder="New Password" type="password" /></div>
					</div>
					
					<div class="control-group">
						<div class="controls"><button class="btn btn-primary" type="submit">确认修改</button></div>
					</div>
				</form>
			</div>
				
			<!-- 修改用户名 -->
			<div id="ChangeUserName" style="display:none;">
				<form class="form-horizontal">
					<div class="control-group"><label class="control-label" for="inputUserName">新用户名</label>				
						<div class="controls"><input id="inputUserName" style="width:320px;height:40px;" placeholder="UserName" type="text" /></div>
					</div>
										
					<div class="control-group">
						<div class="controls"><button class="btn btn-primary" type="submit">确认修改</button></div>
					</div>
				</form>
			</div>
		
			<!-- 用户图片  -->
			<div id="UserPhotos" style="display:block;">
				<table class="table table-hover table-striped">
					<thead>
						<tr>
							<th>图片编号</th>
							<th>图片名称</th>
							<th><a href="#">上传时间</a></th>
							<th><a href="#">评论点赞</a></th>
							<th align="right">编辑</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="obj"  varStatus="status">
							<tr>
								<td>${obj.pno}</td>
								<td id="${status.count}">${obj.pname}</td>
								<td><fmt:formatDate value="${obj.ptime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td>${obj.pcomment}</td>
								<td>
									<a class="btn btn-primary" href="# ${status.count}">修改</a>
									<a class="btn btn-primary" href="#">删除</a>
								</td>
							</tr>						
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var div1 = $("#UserPhotos");      //用户图片
		var div2 = $("#UserNews");        //用户消息
		var div3 = $("#ChangePassword");  //修改密码
		var div4 = $("#ChangeUserName");  //修改用户名
		var div5 = $("#UploadPhotos");    //上传图片 
		var div = [div1, div2, div3, div4, div5]
		
		$("#select #p").click(function Select(){
			var str = $(this).text();	
			var i = 1;
			if(str == "我的图片")i = 1;
			
			else if(str == "用户信息")i = 2;
			
			else if(str == "修改密码")i = 3;
			
			else if(str == "修改昵称")i = 4;
			
			else i = 5; 
			for(var j=1; j<6; j++){
				if(j == i)
					div[j-1].show();
				else 
					div[j-1].hide();
			}
		});
		
	});	
</script>

</body>
</html>












