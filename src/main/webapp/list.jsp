<%--
  Created by IntelliJ IDEA.
  User: thaodangxuan
  Date: 05/07/2021 sau CN
  Time: 09:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form action="/ServletDriver">
        <h1>LIST USER</h1>
        <table border="1" cellpadding="5">
         <tr>
             <th>ID</th>
             <th>NAME</th>
             <th>EMAIL</th>
             <th>COUNTRY</th>
             <th>EDIT</th>
             <th>DELETE</th>
         </tr>
            <c:forEach var="user" items="${userList}">
            <tr>
                <td><c:out value="${user.user_id}"></c:out></td>
                <td><c:out value="${user.user_name}"></c:out></td>
                <td><c:out value="${user.user_email}"></c:out></td>
                <td><c:out value="${user.user_country}"></c:out></td>
                <td>
                    <a href="">EDIT</a>
                </td>
                <td>
                    <a href="">DELETE</a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
