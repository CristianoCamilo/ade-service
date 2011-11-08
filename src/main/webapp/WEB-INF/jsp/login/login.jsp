<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><fmt:message key="login.title"/></title>

<link rel="stylesheet" type="text/css" media="all" href="/css/login.css"/>
</head>
  <link href="css/login.css" media="screen" rel="stylesheet" type="text/css" />
  <body>
    <div id="form_login">
     <form action="login/validate" method="post">
      <div id="border-top" class="h" >
        <div>
          <div>
          </div>
        </div>
      </div>
      <div id="border" >
        <br/>
        <table style="right: 10%; left: 10%; position: relative;">
          <tr>
            <td><label><fmt:message key="login.username"/></label></td>
          </tr>
          <tr>
            <td><input type="text" name="login" id="login" size="40px" /></td>
          </tr>
          <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
          <tr>
            <td><label><fmt:message key="login.password"/></label></td>
          </tr>
          <tr>
            <td><input type="password" name="password" id="password" size="40px" /></td>
          </tr>
          <tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
          <tr>
          	<td><input type="submit" value='<fmt:message key="login.execute"/>'></td>
          </tr>
        </table>
        <br/>
      </div>
       </form>
    </div>
  </body>
</html>





