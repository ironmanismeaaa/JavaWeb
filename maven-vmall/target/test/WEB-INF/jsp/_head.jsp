<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/head.css"/>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="common_head">
	<div id="line1">
		<div id="content">
		
		 
		  <c:if test="${ empty sessionScope.user }">
		 	<a href="${ pageContext.request.contextPath }/index/login">登录</a>	 &nbsp;	
			 <a href="${ pageContext.request.contextPath }/index/regist">注册</a>			 
		 </c:if>	
		 	 
		 <c:if test="${ !(empty sessionScope.user) }">
		 	 	"欢迎${ sessionScope.user.uname }回来~~&nbsp;"
		 	<a href="${ pageContext.request.contextPath }/index/logout">退出</a>		 
		 </c:if>		
		</div>	
	</div>
	<div id="line2">
		<img id="logo" src="${ pageContext.request.contextPath }/img/head/logo.png"/>
		<span id="goto">
			<a id="goto_order" href="${pageContext.request.contextPath}/order/showorder">我的订单</a>
			<a id="goto_cart" href="${pageContext.request.contextPath}/cart/showcart">我的购物车</a>&nbsp;
		</span>
		
	</div>
	<div id="line3">
		<div id="content">
			<ul>
				<li><a href="${ pageContext.request.contextPath }/index.jsp">首页</a></li>
				<li><a href="${ pageContext.request.contextPath }/prodlist">全部商品</a></li>
				<li><a href="${ pageContext.request.contextPath }/prodclass/家用电器">家用电器</a></li>
				<li><a href="${ pageContext.request.contextPath }/prodclass/平板">平板</a></li>
				<li><a href="${ pageContext.request.contextPath }/prodclass/手机">手机</a></li>
				<li><a href="${ pageContext.request.contextPath }/prodclass/手表">手表</a></li>
				<li><a href="${ pageContext.request.contextPath }/prodclass/智能屏">智能屏</a></li>
				<li><a href="${ pageContext.request.contextPath }/prodclass/电脑">电脑</a></li>
				<li><a href="${ pageContext.request.contextPath }/prodclass/耳机">耳机</a></li>
				<li><a href="${ pageContext.request.contextPath }/prodclass/路由器">路由器</a></li>
			</ul>
		</div>
	</div>
</div>