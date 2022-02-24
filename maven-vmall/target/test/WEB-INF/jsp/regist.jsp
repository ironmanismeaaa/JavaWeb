<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>欢迎注册</title>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/regist.css"/>
		<script  type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="${ pageContext.request.contextPath }/js/regist.js">
			</script>
		<script>
		/* 点击图片换一张验证码  */
		//浏览器只要发现图片的src地址变化，图片就会变化。
		$(function(){
			var msg='${msg}';
			if(msg.length!=0){
				alert(msg);
			}
			$("#img").click(function(){
				$(this).attr("src","${ pageContext.request.contextPath }/index/valiImage?time="+new Date().getTime());
			});
			
			//给所有输入框添加失去输入焦点的事件  当失去输入焦点时检查输入是否为空或者两次密码是否一致，或者邮箱格式是否正确。
			$("input[name='uname']").blur(function(){
				if(!formobj.checkNull("uname", "用户名不能为空！")){
					return false;						
				}else{
					var url="${ pageContext.request.contextPath }/user/checkUser";
					var uname=$("input[name='uname']").val();
					$.post(url,{"username":uname},
						function(data){
							alert(data);

						}
					);
				}
			});

		});
		function gtcd(){
			
			if(!formobj.checkNull("email", "邮箱不能为空！")){
				return;
			}
			if(!formobj.checkEmail("email","邮箱格式不正确！")){
				return;
			}
			// 设置禁用效果，不再响应点击事件
			$("#gd").attr("disabled","disabled");
			var i=60;
			var si= setInterval(function(){
				$("#gd").text(i+"s");
				i=i-1;
				if(i==0){
					clearInterval(si);
					$("#gd").text("获取验证码");
					$("#gd").removeAttr("disabled");
					return;
				}
			},1000);
			console.log("nn");
			var url="${ pageContext.request.contextPath }/user/sendcode";
			var email=$("input[name='email']").val();
			$.post(url,{"email":email},
				function(data){
					alert(data);
				}
			);
		}
		</script>
	</head>
	<body>
	<!-- onsubmit事件在表单提交时触发，该事件会根据返回值决定是否提交表单，  
	          如果onsubmit="return true"会继续提交表单，如果onsubmit="return false" 
	          表单将不会提交 
	     onsubmit="" 引号中报错并不是因为代码有问题，而是MyEclipse工具在检查语法认为这个代码有问题。其实没有错误     
	-->
		<div>
		<form onsubmit="return formobj.checkForm();" action="${ pageContext.request.contextPath }/user/regist" method="POST">
			<h1>欢迎注册VMall</h1>
			<table>
				<tr>
					<td class="tds">用户名：</td>
					<td>
						<input type="text" name="uname" value="${ param.uname }"/>
						<span id="uname_msg"></span>
					</td>
					
				</tr>
				<tr>
					<td class="tds">密码：</td>
					<td>
						<input type="password" name="upwd"  value="${ param.upwd }"/>
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tds">确认密码：</td>
					<td>
						<input type="password" name="upwd2" value="${ param.upwd2 }"/>
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tds">电话号码：</td>
					<td>
						<input type="text" name="uphone" value="${ param.uphone }"/>
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tds">邮箱：</td>
					<td>
						<input type="text" name="email" value="${ param.email }"/>
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="tds">验证码：</td>
					<td>
						<input  type="text" name="valistr" value=""/>
						<button id="gd" onclick="gtcd()" type="button" class="bt">获取验证码</button>
						
					</td>
				</tr>
				<tr>
					<td class="sub_td" colspan="2" class="tds">
						<input type="submit" value="注册用户"/>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</body>
</html>