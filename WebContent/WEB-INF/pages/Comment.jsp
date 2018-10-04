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
	<link href="./layoutit/blogs.css" rel="stylesheet">
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
	<script type="text/javascript" src="http://www.bootcss.com/p/layoutit/ckeditor/config.js?t=D3NA"></script>
	<link rel="stylesheet" type="text/css" href="http://www.bootcss.com/p/layoutit/ckeditor/skins/moono/editor.css?t=D3NA">
	<script type="text/javascript" src="http://www.bootcss.com/p/layoutit/ckeditor/lang/zh-cn.js?t=D3NA"></script>
	<script type="text/javascript" src="http://www.bootcss.com/p/layoutit/ckeditor/styles.js?t=D3NA"></script>
	
	<!-- 网络包 -->
	<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> -->
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
   	<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>  	   	
</head>
<body>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
		
			<!-- 导航栏 -->
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
				<div class="span3">
				</div>
				<div class="span7">				
					<div class="row-fluid">
					
						<!-- 图片显示 -->
						<div class="span6">
							<img alt="320x450" src="${photo.psrc}" />
						</div>									
						
						<!-- 图片相关信息 -->
						<div class="span6">
							<ul id="info">
								<li><h3>图片名称：${photo.pname}</h3></li>
								<li><h5>图片上传者：${user1.userName}</h5></li>
								<li><h5>图片上传时间：<fmt:formatDate value="${photo.ptime}" pattern="yyyy-MM-dd HH:mm:ss" /></h5></li>								
								<li><h5>图片故事：${photo.pstory}</h5></li>
								<li><h5>图片评赞：${photo.pcomment}</h5></li>
							</ul>
							
							<br/><br/>
							
							
						</div>
						
					</div>
					<br/><br/>
					
					<!-- 显示评论 -->
					<div class="row-fluid">
						<div class="span12">
						
						<c:forEach items="${commends}" var="commend" varStatus="status">
							<div class="feedbackItem">
								<div class="feedbackListSubtitle">									
									<a href="#4035327" class="layer">#&nbsp;&nbsp;${status.count}&nbsp;&nbsp;楼</a>
									<a name="4035327" id="comment_anchor_4035327"></a>  
									&nbsp;&nbsp;<span class="comment_date"><fmt:formatDate value="${commend.commTime}" pattern="yyyy-MM-dd HH:mm:ss" /></span> 
									&nbsp;&nbsp;<a id="a_comment_author_4035327" href="#this" target="_blank">${commend.uName}</a>											
								</div>
								
								<div class="feedbackCon">									
									<div id="comment_body_4035327" class="blog_comment_body">${commend.comm}</div>
									<br/><br/>
									<div class="comment_vote">
										<a href="javascript:void(0);" class="comment_digg" onclick="return voteComment(4035327,'Digg',this)">支持(${commend.goodComm})</a>						
									</div>
								</div>
							</div>			
						</c:forEach>
																													
						</div>
					</div>
					
					
					<!-- 发表评论 -->
					<div class="row-fluid">
						<div class="span12">
								
							<div id="comment_nav"><span id="span_refresh_tips"></span>
								<a href="#" onclick="return RefreshPage();">刷新页面</a>
								<a href="#top">返回顶部</a>
							</div>	
							<br/>
							<div id="commentform_title">发表评论</div>
							<span id="tip_comment" style="color:Red"></span>
							<p>
								昵称：<input type="text" id="tbCommentAuthor" class="author" disabled="disabled" size="50" value="${user2.userName}">
							</p>
							<div class="commentbox_main">
								<div class="commentbox_title">
									<div class="commentbox_title_left">评论内容：</div>
									<div class="commentbox_title_right"></div>
								</div>
								<div class="clear"></div>
								<textarea id="tbCommentBody" style="width:640px;height:240px;"></textarea>
							</div>
							<br/>
							<p id="commentbox_opt">
								<input hidden="hidden" name="userID" value="${user2.userID}"/>						
								<input id="btn_comment_submit" type="button" class="comment_btn" value="提交评论">
								<input hidden="hidden" name="pno" value="${photo.pno}"/>
								<span id="span_comment_canceledit" style="display:none">
							</p>
						</div>
					</div>
				</div>
				
				<div class="span2">
				</div>
				
			</div>
		</div>
	</div>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

<!-- 提交评论 -->
<script type="text/javascript">
	$(document).ready(function(){
		$("#btn_comment_submit").click(function Commendig(){
			var commend = $("#tbCommentBody").val();//获取评论内容 
			var userID = $(this).prev().val();   //获取评论用户的ID 
			var pno = $(this).next().val();    //获取图片编号
			var pcomment = $("#info li:eq(4)").children().text().slice(5); //获取图片评赞数 
			$.ajax({
				url:"${pageContext.request.contextPath}/submitComment",
				dataType:"text",
				type:"post",
				contenType:"application/text",
				data:{"commend":commend,"userID":userID,"pno":pno,"pcomment":pcomment},
				async: true,
				success: function(data){
					alert(data);
					pcomment = pcomment+1;
					$("#info li:eq(4)").children().html("图片评赞："+pcomment);
					window.location.reload();
				},
				error: function(){
					alert("系统正忙！");
				}
			}); 
		});
		
	});

</script>
</body>
</html>







