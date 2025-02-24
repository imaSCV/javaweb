<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.ResultSet" %>
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
<style>
        /* 添加CSS样式以居中显示图片 */
        .centered-image {
            display: block;
            margin-left: auto;
            margin-right: auto;
            width: 50%; /* 根据需要调整宽度 */
        }
 
        /* 可选的表格样式调整 */
        table {
            width: 80%; /* 根据需要调整表格宽度 */
            margin: 0 auto; /* 表格居中 */
            border-collapse: collapse; /* 合并边框 */
        }
 
        th, td {
            padding: 10px; /* 单元格内边距 */
            text-align: left; /* 文本左对齐 */
        }
    </style>
</head>

<body>

    <h2>Database Table Contents</h2>
    <table border="1">
        <tr>
            <th>id</th>
            <th>num</th>
            <th>name</th>
            <th>stuaues</th>
            <!-- Add more th elements as per your table columns -->
        </tr>
       <%
    ResultSet rs = (ResultSet) request.getAttribute("resultSet");
    try {
        while (rs.next()) {
%>
<tr>
    <td><%= rs.getInt("idinfotb") %></td>
    <td><%= rs.getString("stunum") %></td>
    <td><%= rs.getString("stuname") %></td>
    <td><%= rs.getInt("stuats") %></td>
    <td>
        <button onclick="editRow(<%= rs.getInt("idinfotb") %>)">修改</button>
    </td>
</tr>
<%
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
%>
    </table>
</body>

</html>