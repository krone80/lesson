<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="form-1" action="/Sample1/CDIServlet" method="post">
		入力：<input type="text" name="myName">
		<input type="submit">
	</form>
	出力(myName)：${myInfo.myName}
	出力(myId)：${myInfo.myId}
</body>
</html>