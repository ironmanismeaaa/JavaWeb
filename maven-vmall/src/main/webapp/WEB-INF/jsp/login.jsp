<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/login.css"/>
		<title>EasyMall欢迎您登录</title>
		<script  type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.4.2.js"></script>
		<script type="text/javascript">
			$(function(){
				var msg='${messageError}';
				if(msg.length!=0){
					alert(msg);
				}
			});
		</script>
	</head>
	<body>
		<div class="lg">
			<label class="l1">VMALL</label>
			<label class="l2">华为商城，欢迎你！</label>
		</div>
		<div class="ct">
			<h1>欢迎登录VMall</h1>
			<form action="${ pageContext.request.contextPath }/user/login" method="POST">			
				<table>
					<tr>	
					 	
						<td class="tdx">用户名：</td>
						<td><input type="text" name="uname" value="${ user.uname }"/></td>
					</tr>
					<tr>
						<td class="tdx">密&nbsp;&nbsp; 码：</td>
						<td><input type="password" name="upwd" value=""/></td>
					</tr>
					
					<tr>
						<td colspan="2" style="text-align:center">
							<input type="submit" value="登录"/>
						</td>	
					</tr>
				</table>
			</form>		
		</div>
	</body>
</html>

