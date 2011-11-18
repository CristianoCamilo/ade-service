<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title><fmt:message key="login.title" /></title>
</head>
<link href="css/login.css" media="screen" rel="stylesheet" type="text/css" />
<body>
	<div id="form_login">
		<div id="border-top" class="h">
			<div>
				<div></div>
			</div>
		</div>
		<div id="border">
			<div>
				<p>
					<label><fmt:message key="login.username" />
					</label><br /> <input type="text" name="login" id="login" size="40px" />
				</p>
				<p>
					<label><fmt:message key="login.password" />
					</label><br /> <input type="password" name="password" id="password" size="40px" />
				</p>
				<p>
					<input type="submit" value='<fmt:message key="login.execute"/>' />
				</p>
			</div>
		</div>
	</div>
</body>
</html>

