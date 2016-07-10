<!DOCTYPE html>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>在线教学系统</title>
	<link href="../../css/bootstrap.css" rel="stylesheet">
	<script type="text/javascript" src="../../js/jquery.min.js"></script>
	<script type="text/javascript" src="../../js/jquery.json.js"></script>
	<script type="text/javascript" src="../../js/jquery.form.js"></script>
	<script type="text/javascript" src="../../js/bootstrap.js"></script>
	<script type="text/javascript" src="../../js/common.js"></script>
  </head>
  <body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	  <div class="container">
		<div class="navbar-header">
		  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			<span class="sr-only">导航</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		  </button>
		  <a class="navbar-brand" href="#">小草课堂</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
		  <form id="loginForm" method="post" class="navbar-form navbar-right">
			<div class="form-group">
			  <input type="text" name="user_id" placeholder="用户名" class="form-control" required autofocus>
			</div>
			<div class="form-group">
			  <input type="text" name="pwd" placeholder="密码" class="form-control" required>
			</div>
			<button type="submit" name="login" class="btn btn-success">登陆</button>
		  </form>
		</div><!--/.navbar-collapse -->
	  </div>
	</nav>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
	  <div class="container">
	  <spring:url value="/page/test/next.html" var="formUrl"/>
	 	<h1>测试完成，查看成绩请点下面的链接</h1>
	 	<p><a class="btn btn-primary btn-lg" href="<spring:url value="/page/test/viewResult.html" htmlEscape="true" />">最终成绩</a></p>
	  </div>
	</div>

	<div class="container">
	  <hr>
	
	  <footer>
		<p>stmChina Company 2014</p>
	  </footer>
	</div> <!-- /container -->

	<script type="text/javascript">
		$(document).ready(function() {
			$('#user_id').focus();
			$('#loginForm').ajaxForm(); 
			$('#loginForm').submit(function() { 
				var options = { 
					url: serverContext + '/login/login', 
					type: 'POST', 
					dataType: 'TEXT',
					success: function(data) {
						if (data == 'SUCCESS') {
							window.location.href = serverContext + '/page/main/main.html';
						} else {
							// 用户名密码错误
							$.messager.alert({
											msg : '用户名密码错误.',
											title : '提示'
										});
							var user_id = $('#user_id');
							$(user_id).focus();
							$(user_id).css('backgroundColor','#CC9933');
						} 
					},
					error : function(XMLHttpRequest, textStatus){
						// Ajax提交失败.
						$.messager.alert({
											msg : 'Ajax提交失败.',
											title : '提示'
										});
					}
				};
				$('#loginForm').ajaxSubmit(options);
			 	return false; 
			}); 
		} );
	</script>
  </body>
</html>