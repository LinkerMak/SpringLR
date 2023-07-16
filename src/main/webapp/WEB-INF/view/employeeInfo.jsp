<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2> Employee Info</h2>
<br>




<form:form action="saveEmployee" modelAttribute="buffer" >

  <form:hidden path="employee.id"/>

  Name <form:input path="employee.name"/>
  <br><br>
  Surname <form:input path="employee.surname"/>
  <br><br>
  Department <form:select path="employee.department">
  <form:option value="Human Resources" label="HR"/>
  <form:option value="Sales" label="Sales"/>
  <form:option value="IT" label="IT"/>
  </form:select>
  <br><br>
  Salary <form:input path="employee.salary"/>
  <br><br>
  Section
  <form:checkboxes path="sections" items="${buffer.sectionList}"/>
  <br><br>
  <input type="submit" value="OK">
</form:form>
</body>
</html>
