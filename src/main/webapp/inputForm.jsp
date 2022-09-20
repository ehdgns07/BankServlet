<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>inputForm</title>
</head>
<body>
<form>
	통장을 선택하세요 <select name="account">
					<option value="${account.getId()}"></option>
</select>
	입금할 금액을 입력하세요 : <input type="Number"/>
	
</form>
</body>
</html>
