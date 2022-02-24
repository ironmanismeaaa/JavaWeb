<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/index.css"/>
		<title>Huawei</title>
	</head>
	<body>
	<!-- 将头部(_head.jsp)包含进来 -->
	<jsp:include page="/WEB-INF/jsp/_head.jsp"/>
		<div id="index">
			<div id="line1_d">
				<img src="${ pageContext.request.contextPath }/img/index/big.jpg"/>
			</div>
			<div id="line2">
				<img id="line2_1" src="${ pageContext.request.contextPath }/img/index/1.png"/>
				<img id="line2_2" src="${ pageContext.request.contextPath }/img/index/2.png"/>
				<img id="line2_3" src="${ pageContext.request.contextPath }/img/index/3.png"/>
			</div>
			<div id="line3">
				<img id="line3_1" src="${ pageContext.request.contextPath }/img/index/4.png"/>
				<img id="line3_2" src="${ pageContext.request.contextPath }/img/index/5.png"/>
				<img id="line3_3" src="${ pageContext.request.contextPath }/img/index/6.png"/>
			</div>
			<div id="line4">
				<img id="line4_1" src="${ pageContext.request.contextPath }/img/index/7.png"/>
				<img id="line4_2" src="${ pageContext.request.contextPath }/img/index/8.png"/>
				<img id="line4_2" src="${ pageContext.request.contextPath }/img/index/9.png"/>
			</div>
			
			<div id="line5_d">
				<img src="${ pageContext.request.contextPath }/img/index/foot.png"/>
			</div>
		</div>
		<!-- 将头部(_foot.jsp)包含进来 -->
	<jsp:include page="/WEB-INF/jsp/_foot.jsp"/>
	+
	</body>
</html>
