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
<title>查找</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

    <div class="formbody">
    
    <div class="formtitle"><span>查找</span></div>
	    <form action="uoloadServlvt"   method="post"> ////12.14
	        
						
					<li><input name="" type="submit" class="loginbtn" value="提交" /><label><input
						
							name="" type="checkbox" value="" checked="checked" /></label><label><a></a></label></li>			    
	    	</ul>
	    </form>
 
    
    </div>


</body>

</html>