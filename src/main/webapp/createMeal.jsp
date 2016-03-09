<%--
  Created by IntelliJ IDEA.
  User: Мирошниченко
  Date: 6.3.2016
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create meal</title>
</head>
<body>
<form action="create" method="post">
    <label>Date</label><input type="text" name="date" /><br/>
    <label>Description</label><input type="text" name="description" /><br/>
    <label>Calories</label><input type="text" name="calories" /><br/>
    <input type="submit" value="Добавить"/>
</form>
</body>
</html>
