<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактировать</title>
</head>
<body>
<form action="upd" method="post">
    <input type="hidden" name="id" value="${meal.getId()}"/>
    <label>Date</label><input type="text" name="date" value="${meal.getDateTime()}"/><br/>
    <label>Description</label><input type="text" name="description" value="${meal.getDescription()}"/><br/>
    <label>Calories</label><input type="text" name="calories" value="${meal.getCalories()}"/><br/>
    <input type="submit" value="Изменить"/>
</form>
</body>
</html>
