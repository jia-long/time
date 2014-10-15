<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="regist" method="post">
		<s:textfield name="user.name" /><br /><br />
		<input type="password" name="user.password" /><br /><br />
		<input type="text" name="user.birthday" /><br /><br />
		<input type="text" name="user.money" /><br /><br />
		<input type="submit" value="submit" />
	</s:form>
</body>
</html>