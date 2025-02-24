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
<title>添加</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

<% 
  // 从请求中获取操作结果（注意：若使用redirect，则此处应使用getParameter）
  Boolean success = (Boolean) request.getAttribute("operationResult");
  // 若操作成功，则输出一个JavaScript变量来标记这一点
  if (success != null && success) {
%>
    <script type="text/javascript">
      window.onload = function() {
        alert('添加成功！');
      };
    </script>
<%  
  }
%>
    <div class="formbody">
    
    <div class="formtitle"><span>添加</span></div>
	    <form action="addServlet"   method="post"> ////12.15
	        <ul class="forminfo">
	   
	       			 <li><input name="id" type="text" class="loginuser"value="id" onclick="JavaScript:this.value=''" /></li>
					<li><input name="stunum" type="text" class="loginuser"value="学号" onclick="JavaScript:this.value=''" /></li>
					<li><input name="stuname" type="text" class="loginpwd"value="姓名" onclick="JavaScript:this.value=''" /></li>
					<li><input name="" type="submit" class="loginbtn" value="提交" /><label><input
						
							name="" type="checkbox" value="" checked="checked" /></label><label><a></a></label></li>			    
	    	</ul>
	    </form>
 
    
    </div>


</body>

</html>