<%@  page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<!-- 基地址页面的所有跳转从这里算起<base href="/vote/"> -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>参与投票</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

</head>
<body>

	<div id="header" class="wrap">
		<img src="images/logo.gif" />
	</div>
	<div id="navbar" class="wrap">
		<div class="profile">
			您好，${sessionScope.loginUser.vuUsername} <span class="return"><a
				href="vote_list.action">返回列表</a></span> <span class="addnew"><a
				href="Subject_add.action">添加新投票</a></span> <span class="modify"><a
				href="Subject_update.action">维护</a></span>

		</div>
		<div class="search">
			<form method="post" action="Subject_search.action">
				<input type="text" name="keywords" class="input-text" value="" /><input
					type="submit" name="submit" class="input-button" value="" />
			</form>
		</div>
	</div>

	<div id="vote" class="wrap">
		<h2>参与投票</h2>

		<ul class="list">
			<li>
				<h4>${sessionScope.voteBean.vsTitle}</h4>
				<p class="info">共有 ${sessionScope.voteBean.optionCount}
					个选项，已有${sessionScope.voteBean.voteUserCount} 个网友参与了投票。</p>
					<label style="color: red;">${sessionScope.errorMsg}</label>
			<c:remove var="errorMsg" scope="session"/>  
				<form method="post" action="vote_save.action">
					<input type="hidden"  name="vsId"value="${sessionScope.voteBean.vsId}" /> 
					<input type="hidden" name="vuId" value="${sessionScope.loginUser.vuId}" />
					<ol>
						<c:set var="sType" value="${sessionScope.voteBean.vsType eq 1 ? 'radio' : 'checkbox' }" />
						<c:forEach items="${sessionScope.voteBean.options}" var="option">
							<li><input type="${sType}" name="voId" value="${option.voId}" />${option.voOption}</li>
						</c:forEach>
					</ol>
					<p class="voteView">
						<input type="image" src="images/button_vote.gif" />
						<a href="vote_view.action?vsId=${sessionScope.voteBean.vsId}"><img src="images/button_view.gif" /></a>
					</p>
				</form>
			</li>
		</ul>
	</div>
	<div id="footer" class="wrap">源辰信息 &copy; 版权所有</div>
</body>
</html>
