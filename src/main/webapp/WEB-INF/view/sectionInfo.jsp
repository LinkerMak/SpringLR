<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2> Employee Info</h2>
<br>




<form:form action="saveSection" modelAttribute="section" >

  Name Section <form:input path="nameS"/>
  <br><br>
  <input type="submit" value="OK">
</form:form>
</body>
</html>
