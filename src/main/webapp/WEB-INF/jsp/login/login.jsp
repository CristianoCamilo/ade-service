<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><fmt:message key="login.title"/></title>

	<link rel="stylesheet" type="text/css" media="all" href="<c:url value="/css/login.css"/>" />
</head>

<body>
	<div id="form_login">
		<div id="border-top" class="h">
			<div>
				<div></div>
			</div>
		</div>
		<div id="border">
			<div class="body">
				<p>
				<c:if test="${not empty errors}">
					<div class="error">
						<c:forEach var="error" items="${errors}">
							<label>${error.message}<br/></label>
						</c:forEach>
					</div>
				</c:if>
				</p>
				<form id="frm_login" action="<c:url value="/login/validate"/>" method="post">
					<p>
						<label><fmt:message key="login.username"/></label><br/>
						 <input type="text" name="login" size="40px"/>
					</p>
					<p>
						<label><fmt:message key="login.password"/></label><br/>
						 <input type="password" name="password" size="40px"/>
					</p>
					<p>
						<input type="submit" class="button" value='<fmt:message key="login.execute"/>'/>
					</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

