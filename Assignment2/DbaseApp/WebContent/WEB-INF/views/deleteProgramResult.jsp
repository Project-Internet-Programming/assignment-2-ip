<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Program Result</title>
</head>
<body>
    <h2>Delete Program Result</h2>
    <c:if test="${param.notFound}">
        <p>Program not found</p>
    </c:if>
    <c:if test="${not param.notFound}">
        <p>Program with ID ${param.id} has been deleted</p>
    </c:if>
    <!-- Add more information as needed -->
</body>
</html>
