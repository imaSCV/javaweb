<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
   		String path=request.getContextPath();
    	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE html>
<html>
<head>
<base href=<%=basePath %>>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>get resoures file</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="formbody">

		<div class="formtitle">
			<span>基本信息</span>
		</div>
		<form action="studentServlet">
			<ul class="forminfo">

				<li>driver : ${requestScope.title}</li>
				<li>url : ${requestScope.messsage}</li>
				<li>RIGHT_ONE: ${requestScope.RIGHT_ONE}</li>
				<li>RIGHT_TWO : ${requestScope.RIGHT_TWO}</li>
				<li>RIGHT_THREE : ${requestScope.RIGHT_THREE}</li>
				<li>RIGHT_FOUR :${requestScope.RIGHT_FOUR}</li>
				<li>RIGHT_FIVE : ${requestScope.RIGHT_FIVE}</li>
				<li>RIGHT_SIX : ${requestScope.RIGHT_SIX}</li>
			</ul>
		</form>


	</div>


</body>

</html>