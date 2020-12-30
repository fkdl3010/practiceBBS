<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/WebExer/JSONHandler">
		성명
		<input type="text" name="name" /><br>
		나이
		<input type="text" name="age" /><br><br>
		결혼유무
		<input type="radio" name="isMarried" value="true"/>
		기혼
		<input type="radio" name="isMarried" value="false"/>
		미혼
		<br><br>
		<button>전송</button>
	</form>
</body>
</html>