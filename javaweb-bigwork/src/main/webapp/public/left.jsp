<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
	$(function() {
		//导航切换
		$(".menuson li").click(function() {
			$(".menuson li.active").removeClass("active")
			$(this).addClass("active");
		});

		$('.title').click(function() {
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if ($ul.is(':visible')) {
				$(this).next('ul').slideUp();
			} else {
				$(this).next('ul').slideDown();
			}
		});
	})
</script>


</head>

<body style="background: #f0f9fd;">
	<div class="lefttop">
		<span></span>菜单
	</div>
<dl class="leftmenu">

            <dd>
                <div class="title">
                    <span><img src="images/leftico01.png" /></span>基础信息
                </div>
                <ul class="menuson">
                    <li><cite></cite><a href="index.html" target="rightFrame">首页模版</a><i></i></li>
                    <li class="active"><cite></cite><a href="right.html" target="rightFrame">数据列表</a><i></i></li>
                    <li><cite></cite><a href="imgtable.html" target="rightFrame">图片数据表</a><i></i></li>
                    <li><cite></cite><a href="form.html" target="rightFrame">添加编辑</a><i></i></li>
                </ul>
            </dd>
        

        <dd>
				<div class="title">
					<span><img src="images/leftico01.png" /></span>基础信息
				</div>
				<ul class="menuson">
					<li><cite></cite><a href="index.html" target="rightFrame">首页模版</a><i></i></li>
					<li class="active"><cite></cite><a href="right.html"
						target="rightFrame">数据列表</a><i></i></li>
					<li><cite></cite><a href="imgtable.html" target="rightFrame">图片数据表</a><i></i></li>
					<li><cite></cite><a href="form.html" target="rightFrame">添加编辑</a><i></i></li>
				</ul>
			</dd>
			
   
		<dd>
			<div class="title" >
				<span><img src="images/leftico03.png" /></span>查询
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="public/action/toFind.jsp" target="rightFrame">查询</a><i></i></li>
			</ul>
		</dd>


		<dd>
			<div class="title">
				<span><img src="images/leftico04.png" /></span>添加
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="public/action/toAdd.jsp"  target="rightFrame">添加</a><i></i></li>
			</ul>
		</dd>
		
		
		<dd>
			<div class="title">
				<span><img src="images/leftico02.png" /></span>修改
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="public/action/up.jsp" target="rightFrame">编辑内容</a><i></i></li>
			</ul>
		</dd>
		

		<dd>
			<div class="title">
				<span><img src="images/leftico02.png" /></span>详情
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="#">编辑内容</a><i></i></li>
			</ul>
		</dd>
	</dl>

</body>
</html>
