<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
	<link href="${pageContext.request.contextPath}/css/prodList.css" rel="stylesheet" type="text/css">
</head>
<body>

	<%@ include file="_head.jsp" %>
	<div id="content">
		<form action="${ pageContext.request.contextPath }/mongodbtest/mongodbCCC" method="post">
		<div id="prod_content">
			<c:forEach items="${products }" var="prod">
			    
				<div class="prod_div">
					<a href="${pageContext.request.contextPath}/prodInfo?pid=${prod.id}" target="_blank">
						
					</a>
				
				<div class="prod_name_div">
					<a href="${pageContext.request.contextPath}/prodInfo?pid=${prod.id}" target="_blank">
						<c:if test="${fn:length(prod.name) > 20 }">
 							${fn:substring(prod.name,0,20)}...
						</c:if>
						<c:if test="${fn:length(prod.name) <= 20}">
 							${prod.name}
						</c:if>
					</a>
				</div>
				<div id="prod_price_div">
					￥${prod.price}元
				</div>
				<input name="proinfo" value= "${prod.id}" />
				<input value="${prod.name}" name="proinfo"/>
				<input value="${prod.price}" name="proinfo"/>
				<input value="${prod.category}" name="proinfo"/>
				<input value="${prod.pnum}" name="proinfo"/>
				<input value="${prod.imgurl}" name="proinfo"/>
				<input value="${prod.description}" name="proinfo"/>
				<input value="${prod.soldnum}" name="proinfo"/>
				<br></br>
				<input type="submit" value= "${prod.id }" name="proID">插入/更新数据</input>
				<br></br>
				<input type="submit" value= "${prod.id }" name="deleteproID">删除数据</input>
			</div>
			</c:forEach>
			<div style="clear: both"></div>
		</div>
		</form>
		<c:forEach items="${products }" var="prod">
		</c:forEach>
	</div>
	<%@ include file="_foot.jsp" %>
</body>
</html>
