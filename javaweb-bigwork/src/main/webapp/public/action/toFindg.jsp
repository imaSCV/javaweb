<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>获取资源文件</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

    <div class="formbody">
        <div class="formtitle"><span>基本信息</span></div>
        <form action="studentServlet">
            <ul class="forminfo">
                <c:choose>
                    <c:when test="${empty requestScope.studentinfo.name}">
                        <li>查无此人</li>
                    </c:when>
                    <c:otherwise>
                        <li>id : ${requestScope.studentinfo.getId()}</li>
                        <li>name : ${requestScope.studentinfo.getName()}</li>
                        <li>status : ${requestScope.studentinfo.getStutat()}</li> <!-- 注意这里可能是status而不是stutat -->
                    </c:otherwise>
                </c:choose>
            </ul>
        </form>
    </div>

</body>
</html>