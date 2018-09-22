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
	<meta name="title" content="LayoutIt! - Bootstrap可视化布局系统">
	<meta name="description" content="LayoutIt! 可拖放排序在线编辑的Bootstrap可视化布局系统">
	<meta name="keywords" content="可视化,布局,系统">
	<title>Bootstrap可视化布局系统</title>

	<!-- Le styles -->
	<link href="./layoutit/bootstrap-combined.min.css" rel="stylesheet">
	<link href="./layoutit/layoutit.css" rel="stylesheet">
	<link href="./css/bootstrap.min.css" rel="stylesheet">


	<!-- Fav and touch icons -->
	<link rel="shortcut icon" href="img/favicon.png">
	<script type="text/javascript" src="./js/json2.js"></script>
	<script type="text/javascript" src="./js/jquery-3.1.1.min.js"></script>
	<!--[if lt IE 9]>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
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
   	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://cdn.bootcss.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>
<body>
<form:form action="userComment" method="post">
<div class="container-fluid">
	
	<div class="row-fluid">
	<div class="row-fluid">
	<div class="span12">
			<div class="navbar navbar-inverse">
				<div class="navbar-inner">
					<div class="container-fluid">
						<a class="btn btn-navbar" data-target=".navbar-responsive-collapse" data-toggle="collapse"> </a> 
						<em><a class="brand" href="#">PhotoStory</a></em>

					<div class="nav-collapse collapse navbar-responsive-collapse">
						<ul class="nav pull-right" >
							<li>
								<ul class="nav">
									<li class="active"><a href="#">主页</a></li>
									<li><a href="#">链接</a></li>
									<li><a href="https://www.baidu.com/">消息<span class="badge badge-success" contenteditable="true">1</span> </a></li>
								</ul>
							</li>
						</ul>
					</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		<div class="span2">
			<div class="tabbable tabs-below" id="tabs-738031">
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#panel-370468">图片分类</a></li>
					<li class=""><a data-toggle="tab" href="#panel-122135">最佳图片</a></li>
				</ul>

					<div class="tab-content">
						<div class="tab-pane active" id="panel-370468">
							<p><big><em><strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<a href="#">所有图片</a></strong></em></big></p>

								<p>&nbsp;</p>

							<p><big><em><strong>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<a href="#">动漫图片</a></strong></em></big></p>

								<p>&nbsp;</p>

							<p><big><em><strong>&nbsp; &nbsp; &nbsp;&nbsp;<a href="#">瞬间感动</a></strong></em></big></p>

								<p>&nbsp;</p>

							<p><big><em><strong>&nbsp; &nbsp; &nbsp;<a href="#">神奇事件</a></strong></em></big></p>

								<p>&nbsp;</p>

							<p><big><em><strong>&nbsp; &nbsp; &nbsp;&nbsp;<a href="#">房屋装修</a></strong></em></big></p>

								<p>&nbsp;</p>

							<p><big><em><strong>&nbsp; &nbsp; &nbsp;<a href="#">天气气象</a></strong></em></big></p>

								<p>&nbsp;</p>

							<p><big><em><strong>&nbsp; &nbsp; &nbsp;&nbsp;<a href="#">搞笑图片</a></strong></em></big></p>

								<p>&nbsp;</p>

							<p><big><em><strong>&nbsp; &nbsp; &nbsp;&nbsp;<a href="#">网络游戏</a></strong></em></big></p>
						</div>

						<div class="tab-pane" id="panel-122135">
							<ol>
								<li>
									<h3><em><small><strong><a href="#">所发生时有图片</a></strong></small></em></h3>
								</li>
								<li>
									<h3><em><small><strong><a href="#">动漫书凡图片</a></strong></small></em></h3>
								</li>
								<li>
									<h3><em><small><strong><a href="#">瞬第三方间感动</a></strong></small></em></h3>
								</li>
								<li>
									<h3><em><small><strong><a href="#">神第三方是的发送到奇事件</a></strong></small></em></h3>
								</li>
								<li>
									<h3><em><small><strong><a href="#">房屋水电费水电费装修</a></strong></small></em></h3>
								</li>
									<li>
									<h3><em><small><strong><a href="#">天气得分气象</a></strong></small></em></h3>
								</li>
								<li>
									<h3><em><small><strong><a href="#">搞</a></strong></small></em></h3>
								</li>
								<li>
									<h3><em><small><strong><a href="#">网络得分游戏</a></strong></small></em></h3>
								</li>
								<li>
									<h3><em><small><strong><a href="#">搞笑电风扇图片</a></strong></small></em></h3>
								</li>
								<li>
									<h3><em><small><strong><a href="#">网络游分数戏</a></strong></small></em></h3>
								</li>
							</ol>
					</div>
				</div>
			</div>
		</div>
		<div class="span9">
			<div id="newPhotos">     <!-- 局部刷新图片 -->
			<ul class="thumbnails">
				<li class="span4">
					<div id="photo1" class="thumbnail">
						<img alt="270x380" src="${photos[0].psrc}" />
						<div class="caption">
							<h3>
								${photos[0].pname}
							</h3>
							<p class="pstory">
								${photos[0].pstory}
							</p>
							<p>
								 <a class="btn btn-primary" href="#">赞</a> <a class="btn" href="#">评论</a>
							</p>
						</div>
					</div>
				</li>
				<li class="span4">
					<div id="photo2" class="thumbnail">
						<img alt="270x380" src="${photos[1].psrc}" />
						<div class="caption">
							<h3>
								${photos[1].pname}
							</h3>
							<p class="pstory">
								${photos[1].pstory}
							</p>
							<p>
								 <a class="btn btn-primary" href="#">赞</a> <a class="btn" href="#">评论</a>
							</p>
						</div>
					</div>
				</li>
				<li class="span4">
					<div id="photo3" class="thumbnail">
						<img alt="270x380" src="${photos[2].psrc}" />
						<div class="caption">
							<h3>
								${photos[2].pname}
							</h3>
							<p class="pstory">
								${photos[2].pstory}
							</p>
							<p>
								 <a class="btn btn-primary" href="#">赞</a> <a class="btn" href="#">评论</a>
							</p>
						</div>
					</div>
				</li>
			</ul>
			<ul class="thumbnails">
				<li class="span4">
					<div id="photo4" class="thumbnail">
						<img id="psrc3" alt="270x380" src="${photos[3].psrc}" />
						<div class="caption">
							<h3 class="pstory">
								${photos[3].pname}
							</h3>
							<p class="pstory">
								${photos[3].pstory}
							</p>
							<p>
								 <a class="btn btn-primary" href="#">赞</a> <a class="btn" href="#">评论</a>
							</p>
						</div>
					</div>
				</li>
				<li class="span4">
					<div id="photo5" class="thumbnail">
						<img alt="270x380" src="${photos[4].psrc}" />
						<div class="caption">
							<h3>
								${photos[4].pname}
							</h3>
							<p class="pstory">
								${photos[4].pstory}
							</p>
							<p>
								 <a class="btn btn-primary" href="#">赞</a> <a class="btn" href="#">评论</a>
							</p>
						</div>
					</div>
				</li>
				<li class="span4">
					<div id="photo6" class="thumbnail">
						<img alt="270x380" src="${photos[5].psrc}" />
						<div class="caption">
							<h3>
								${photos[5].pname}
							</h3>
							<p class="pstory">
								${photos[5].pstory}
							</p>
							<p>
								 <a class="btn btn-primary" href="#">赞</a> <a class="btn" href="#">评论</a>
							</p>
						</div>
					</div>
				</li>
			</ul>
			<ul class="thumbnails">
				<li class="span4">
					<div id="photo7" class="thumbnail">
						<img alt="270x380" src="${photos[6].psrc}"/>
						<div class="caption">
							<h3>
								${photos[6].pname}
							</h3>
							<p class="pstory">
								${photos[6].pstory}
							</p>
							<p>
								 <a class="btn btn-primary" href="#">赞</a> <a class="btn" href="#">评论</a>
							</p>
						</div>
					</div>
				</li>
				<li class="span4">
					<div id="photo8" class="thumbnail">
						<img alt="270x380" src="${photos[7].psrc}" />
						<div class="caption">
							<h3>
								${photos[7].pname}
							</h3>
							<p>
								${photos[7].pstory}
							</p>
							<p>
								 <a class="btn btn-primary" href="#">赞</a> <a class="btn" href="#">评论</a>
							</p>
						</div>
					</div>
				</li>
				<li class="span4">
					<div id="photo9" class="thumbnail">
						<img alt="270x380" src="${photos[8].psrc}" />
						<div class="caption">
							<h3>
								${photos[8].pname}
							</h3>
							<p class="pstory">
								${photos[8].pstory}
							</p>
							<p>
								 <a class="btn btn-primary" href="#">赞</a> <a class="btn" href="#">评论</a>
							</p>
						</div>
					</div>
				</li>
			</ul>
			</div>
			
			<div class="row-fluid">
				<div class="span12">
					<div class="pagination pagination-centered">
						<br/>
						<br/>
						<br/>
						<ul>
							<li>
								<ul>
									<li id="previousPage">
										<a href="#">上一页</a>
									</li>
								</ul>
								<ul id="pages">
									<c:forEach var="i" begin="1" end="${pages}">
										<li>
											<a id="pageNo" href="#">${i}</a>
										</li>
									</c:forEach>
								</ul>
								<ul>
									<li id="nextPage">
										<a href="#">下一页</a>
									</li>
									<li id="lastPage">
										<a href="#">尾页</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		
		<div class="span1">
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<p align="center"><strong><em>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </em></strong></p>

<p align="center">&nbsp;</p>

<p align="center">&nbsp;</p>

<p align="center">&nbsp;</p>

<p align="center">&nbsp;</p>

<p align="center">&nbsp;</p>

<p align="center">&nbsp;</p>

<p align="center">&nbsp;</p>

<p align="center">&nbsp;</p>

<p align="center"><strong>
<em>  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Author @zuo Shufan @Zhang Qiong @Yang Baimei</em></strong><br />
<em>  &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Address:湖南省岳阳市岳阳楼区湖南理工学院 414006</em><br />
<em>  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;Email:981022984@qq.com</em><br />
<em>  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Phon: 13617304487</em></p>
		</div>
	</div>
</div>
</form:form>
<script type="text/javascript">
$(document).ready(function(){
	var pageNo = $("#pageNo").text();     //首页
	var pageArray = $("#pages");          //所有页数组
	
	$("#nextPage").click(function nextPage(){ 
		pageNo=(parseInt(pageNo)+1);      //下一页
		pageNo.toString();
		newPage();
	});         		/* 点击下一页局部动作 */
		
    $("#previousPage").click(function previousPage(){
    	if(parseInt(pageNo) == 1){
    		alert("没有了！");
    	}
    	else{
    		pageNo=(parseInt(pageNo)-1);      //下一页
    		pageNo.toString();
    		newPage();
    	}
    	
    }); /* 点击上一页局部动作 */
    
    
    $("#lastPage").click(function lastPage(){
    	pageNo=$("#pages li:last-child").text();  //获取左后一页页数 
    	pageNo=parseInt(pageNo);
    	pageNo.toString();
    	newPage();
    });         /* 点击尾页局部动作 */
    
    
    $("#pages li").click(function lastPage(){
    	pageNo=$(this).index()+1;    //被点击的页号,index()下标从0开始
    	pageNo=parseInt(pageNo);
    	pageNo.toString();
    	newPage();
    });
	function newPage(){     /* 图片刷新 */
		$.ajax({url:"${pageContext.request.contextPath}/newPhotos",
				dataType:"json",                   /* 预期服务器响应数据 */  
				type : "post",                     /* 请求类型 */
				contenType : "application/text",   /* 发送到服务器数据格式 */
				data :{"currentPage":pageNo},      /* 发送到服务器的数据 */
				async : true,                      /* 异步处理 */
				success :function(data){
					for(var i=0;i<9;i++){
						$("#photo"+(i+1)).find("img").attr("src",data[i].psrc);
						$("#photo"+(i+1)).find("h3").html(data[i].pname);
						$("#photo"+(i+1)).find("h3").next().html(data[i].pstory); 
					}
				},
				error :function(){
					alert("数据传输失败");
				}
			});
		}
	
});
</script>   
  </body>
</html>