<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<%--    <link href="<c:url value='/static/css/app.css'/>" rel="stylesheet"></link>--%>
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

<h2> All Employees</h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="emp" items="${allEmps}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <c:url var="showSectionsButton" value="/showSectionById">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>
        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>
                <input type="button" value="Update"
                onClick="window.location.href = '${updateButton}'">
            </td>
            <td>
                <input type="button" value="Delete"
                       onClick="window.location.href = '${deleteButton}'">
            </td>
            <td>
                <input type="button" value="Sections"
                       onClick="window.location.href = '${showSectionsButton}'">
            </td>
        </tr>
    </c:forEach>
</table>
<br>

<input type="button" value="Add"
    onclick="window.location.href= 'addNewEmployee'"/>
<br><br>

<security:authorize access="hasAnyRole('HR','MANAGER')">
    Additional Information
</security:authorize>
<br><br>

<security:authorize access="hasRole('HR')">
    <input type="button" value="salary"
           onClick="window.location.href = 'hrInfo'">
    Only For HR staff
</security:authorize>
<br><br>

<security:authorize access="hasRole('MANAGER')">
    <input type="button" value="Performance"
           onClick="window.location.href = 'managerInfo'">
    Only For Managers
</security:authorize>
<br><br>
<input type="button" value="Sections"
       onClick="window.location.href = 'showSections'">

</body>
</html>