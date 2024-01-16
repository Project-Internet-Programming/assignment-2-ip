<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Instructor</title>
</head>
<body>
    <h2>Add Instructor</h2>
    <form action="/your-app-context/instructor/processAdd" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="gender">Gender:</label>
        <input type="text" id="gender" name="gender" required><br>

        <label for="speciality">Speciality:</label>
        <input type="text" id="speciality" name="speciality" required><br>

        <input type="submit" value="Add Instructor">
    </form>
</body>
</html>
