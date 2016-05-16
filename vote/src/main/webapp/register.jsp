<%@  page contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注   册</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />

<script type="text/javascript">
	function  checking(){
		var pa=document.getElementsByName("vuPassword").valueOf();
		var repa=document.getElementsByName("confirmPassword").valueOf();
		alter("请再次确认密码 ++" + pa);
		if(pa!=repa){
			alter("请再次确认密码");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<div id="header" class="wrap">
	<img src="images/logo.gif" />
</div>
<div id="navbar" class="wrap">
	<div class="search">
		<form method="post" action="Subject_search.action">
			<input type="text" name="keywords" class="input-text" value=""/><input type="submit" name="submit" class="input-button" value="" />
		</form>	
	</div>
</div>
<div id="register" class="box">
	<h2>新用户注册</h2>
	<div class="content">
	   <form method="post" action="user_register" >
			<dl>
				
				<dt>用户名：</dt>
				<dd><input type="text" class="input-text" name="vuUsername" value=""/></dd>
				<dt>密码：</dt>
				<dd><input type="password" class="input-text" name="vuPassword" value=""/></dd>
				<dt>邮箱：</dt>
				<dd><input type="text" class="input-text" name="vuEmail"  value=""/></dd>
				<dt></dt>
				<dd><input type="submit" class="input-button" name="submit" /></dd>
			</dl>
		</form>
		<div class="error">${sessionScope.errorMsg}</div>
			<c:remove var="errorMsg" scope="session"/>  <!--   因为只用一次，所以利用c标签清除 -->
		<div class="error"></div>
	</div>
</div>
<div id="footer" class="wrap">
	源辰信息 &copy; 版权所有
</div>
</body>
</html>
