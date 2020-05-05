<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/jquery-ui.css">
<script src="js/jquery-1.12.4.js"></script>
<script src="js/jquery-ui.js"></script>

<title>Add New User</title>
</head>
<body>
	<script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>

	 <form method="POST" action='UserController' name="frmAddUser">
        User ID : <input type="text" readonly="readonly" name="userid" value="<c:out value="${user.userid}" />" /> 
        <br /> 
        First Name : <input type="text" name="firstName" value="<c:out value="${user.firstName}" />" /> 
        <br /> 
        Last Name : <input type="text" name="lastName" value="<c:out value="${user.lastName}" />" /> 
        <br /> 
        DOB : <input type="text" name="dob" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" />" /> 
        <br /> 
        Email : <input type="text" name="email" value="<c:out value="${user.email}" />" /> 
        <br /> 
        <input type="submit" value="Submit" />
    </form>
</body>
</html>