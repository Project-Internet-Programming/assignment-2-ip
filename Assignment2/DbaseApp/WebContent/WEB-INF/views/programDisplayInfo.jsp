<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Instructor List</title>
</head>
<body>
    <h2>Instructor List</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="instructor" items="${instructors}">
                <tr>
                    <td>${instructor.id}</td>
                    <td>${instructor.name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <h2>Program Information</h2>
    <c:if test="${empty program}">
        <p>Program not found</p>
    </c:if>
    <c:if test="${not empty program}">
        <p>ID: ${program.id}</p>
        <p>Name: ${program.name}</p>
        <!-- Add more fields as needed -->
    </c:if>
</body>
</html>
