<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Database of flats</title>
  </head>
  <body>
      <a href="/input.jsp">Click</a> Add new flat<br/>
      <a href="/get">Click</a>List of all flats<br/>

      <form action="/get" method="POST">
          Filter area: <input type="text" name="area"><br>
          <input type="submit" />
      </form>

      <form action="/get" method="POST">
          Filter address: <input type="text" name="address"><br>
          <input type="submit" />
      </form>

      <form action="/get" method="POST">
          Filter square: <input type="text" name="square"><br>
          <input type="submit" />
      </form>

  </body>
</html>
