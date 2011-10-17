<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="login.title"/></title>
</head>
<body> 
  <form>
    <fmt:message key="login.username"/>
    <input type="text" name="username" /><br/>
 
    <fmt:message key="login.password"/>
    <input type="text" name="password" /><br/>

    <p><input type="submit" value='<fmt:message key="login.execute"/>'></p>
  </form>
</body>
</html>