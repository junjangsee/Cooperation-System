<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	 
	<br>
		<table class="table-striped" width="500" border="0" cellpadding="0"
		cellspacing="0">

		<c:forEach var="searchList" items="${searchList}">
			<tr>
				<td>${searchList.name }</td>
				<td>${searchList.mail }</td>
			</tr>
		</c:forEach>
	</table>

		<br>
	
</body>
</html>