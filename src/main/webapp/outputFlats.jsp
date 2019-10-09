<%--
  Created by IntelliJ IDEA.
  User: LazovoyOV
  Date: 30.09.2019
  Time: 12:07
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
   <% out.println("Listed in the flats database");  %>
</h1>
<table border="1">
    <c:forEach items="${houselist}" var="o">
        <tr>
            <td><c:out value="${o.area}"/></td>
            <td><c:out value="${o.address}"/></td>
            <td><c:out value="${o.square}"/></td>
            <td><c:out value="${o.numberOfRooms}"/></td>
            <td><c:out value="${o.price}"/></td>

        </tr>
    </c:forEach>
</table>
<br/><a href="/input.jsp">Go Back</a>

</body>
</html>
