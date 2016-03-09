<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meal list</title>
</head>
<body>

<table border="1">
    <thead>
    <tr>
        <td>Date</td>
        <td>Description</td>
        <td>Calories</td>
        <td colspan="2">&nbsp</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="meal" items="${userMealsWithExceeded}">
        <tr style="color:${meal.isExceed() ? '#dd1e0b':'#05a31e'}">
            <td>${meal.getDateTime().toLocalDate()} ${meal.getDateTime().toLocalTime()}</td>
            <td>${meal.getDescription()}</td>
            <td>${meal.getCalories()}</td>
            <td><a href="del?id=${meal.getId()}">Удалить</a> </td>
            <td><a href="upd?id=${meal.getId()}">Редактировать</a> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="create">Add meal</a>
</body>
</html>
