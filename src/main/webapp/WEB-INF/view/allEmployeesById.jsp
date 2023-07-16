<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style id="compiled-css" type="text/css">
    tr, h2 {<!--  w   w  w .   d e  m  o   2s    .  co    m-->
    text-align:center;
    }
    table {
      background-color: #FFFFCC;
    }
    h2 {
      background-color: #FFCCFF;
    }
    div {
      border : 1px solid lightgray;
    }

  </style>
</head>
<!doctype html>
<body>

<h2> All Sections</h2>
<br>

<table>
  <tr>
    <th>Name</th>
    <th>Surname</th>
    <th>Department</th>
    <th>Salary</th>
  </tr>

  <c:forEach var="emp" items="${allEmployees}">

  <tr>
    <td>${emp.name}</td>
    <td>${emp.surname}</td>
    <td>${emp.department}</td>
    <td>${emp.salary}</td>
  <tr>
  </c:forEach>
</table>
<br><br>
</body>
</html>