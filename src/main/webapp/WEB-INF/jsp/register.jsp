<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java"  %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
    function reloadCaptcha(){
        var d = new Date();
        $("#captcha_image").attr("src"+d.getTime());
    }
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Account</title>
</head>
<body>

	<h3>Register Account</h3>
	<s:form method="post" modelAttribute="account"
		action="${pageContext.request.contextPath }/account/register">
		<table>
			
			<tr>
				<td>Name</td>
				<td>
					<s:input path="name" required="required"/>
				</td>
			</tr>
			
			<tr>
				<td>Email</td>
				<td>
					<s:input path="email" required="required"/>
				</td>
			</tr>
			<tr>
				<td>Username</td>
				<td>
					<s:input path="username" required="required"/>
				</td>
			</tr>
		
			<tr>
				<td>Password</td>
				<td>
					<s:password path="password" required="required"/>
				</td>
			</tr>
			<tr>
				<td>Captcha</td>
				<td>
					<img id="#captcha_image" src="${pageContext.request.contextPath }/captcha">
					<br>
					<input type="text" name="captcha"  style="margin-top: 5px;">
					<br>
					
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>
					<input type="submit" value=" Register">
				</td>
				
				<td>
					<input type="submit" value="Refresh" onClick="reloadCaptcha()">
				</td>
			</tr>
			
		</table>
	</s:form>

</body>
</html>