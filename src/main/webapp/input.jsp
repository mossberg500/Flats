<%--
  Created by IntelliJ IDEA.
  User: LazovoyOV
  Date: 30.09.2019
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter an apartment </title>
</head>
<body>
<h1>Entering apartment data</h1>

<form action="/add" method="POST">
    Area: <input type="text" name="area"><br>
    Address: <input type="text" name="address"><br>
    Square: <input type="text" name="square"><br>
    NumberOfRooms: <input type="text" name="numberOfRooms"><br>
    Price: <input type="text" name="price"><br>
    <input type="submit"value="Writing  a flat to the DataBase" />
</form>

<br/><a href="/">Go Back</a>
</body>
</html>
