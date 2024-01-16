<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Program</title>
</head>
<body>
    <h2>Update Program</h2>
    <form action="/your-app-context/instructor/processUpdate" method="post">
        <label for="id">Program ID:</label>
        <input type="text" id="id" name="id" required><br>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="note">Note:</label>
        <input type="text" id="note" name="note" required><br>

        <input type="submit" value="Update Program">
    </form>
</body>
</html>
