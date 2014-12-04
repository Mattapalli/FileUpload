<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
		<h1>File Upload to Database Demo</h1>
		<form method="post" action="uploadServlet"
			enctype="multipart/form-data">
			<table border="0">
				
				<tr>
					<td>Xl Upload:</td>
					<td><input type="file" name="xldata" size="50" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save"> <input
						type="reset" value="Reset"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</body>
</html>