<%--
  Created by IntelliJ IDEA.
  User: LazovoyOV
  Date: 09.10.2019
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>
    <% out.println("List of flats");  %>
</h1>
<table border="1">
    <c:forEach items="${filter}" var="o">
        <tr>
            <td><c:out value="${o.area}"/></td>
            <td><c:out value="${o.address}"/></td>
            <td><c:out value="${o.square}"/></td>
            <td><c:out value="${o.numberOfRooms}"/></td>
            <td><c:out value="${o.price}"/></td>

        </tr>
    </c:forEach>
</table>
<br/><a href="/index.jsp">Go Back</a>

</body>
</html>
