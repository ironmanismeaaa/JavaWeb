<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
	<link href="${ pageContext.request.contextPath }/css/addOrder.css" rel="stylesheet" type="text/css">
		
	<script type="text/javascript" src="//api.map.baidu.com/api?v=2.0&ak=K0QZDGKLGwupKqK3RxM8apSXALO8e8pG"></script>
<style>
#container {
	overflow: hidden;
	width: 100%;
	height: 100%;
	margin: 0;
	font-family: "微软雅黑";
}
</style>
</head>
<body>
	<%@ include file = "_head.jsp" %>
	<div class="warp">
		<form action="${ pageContext.request.contextPath }/order/addOrder" name="form1" method="post">
			<h3>增加订单</h3>
			<div id="forminfo" style="display: flex; flex-direction: row">
			<div id="forminfo">
				<span class="lf" style="vertical-align: middle;">收货地址：</span> 
				<label for="textarea"></label>
				<textarea name="receiverinfo" id="textarea" cols="35" rows="3">广东省佛山市南海区狮山镇狮山大学城华南师范大学南海校区</textarea>
				<br> 支付方式：<input name="" type="radio" value="1" checked>&nbsp;在线支付
				  	   <input type="hidden" name="cartIds" value="${cartIds }">
			</div>
				
				<div>
				<div style="width: 400px; height: 400px">
					<div id="container"></div>
				</div>
			</div>
			</div>
			
			
			<table width="999" height="80" border="1" cellpadding="0" cellspacing="0" bordercolor="#d8d8d8">
				<tr>
					<th width="276">商品图片</th>
					<th width="247">商品名称</th>
					<th width="231">商品单价</th>
					<th width="214">购买数量</th>
					<th width="232">总价</th>
				</tr>
				
				<c:set var="sum" value="0"/>	
				<c:forEach items="${carts}" var="cart">
				<tr>
					<td><img src="${ pageContext.request.contextPath }${cart.imgurl}" 
					width="90" height="90" class="prodimg" /></td>
					<td>${cart.name}</td>
					<td>${cart.price}元</td>
					<td>${cart.num}件</td>
					<td>${cart.price*cart.num}元</td>
				</tr>
				<c:set var="sum" value="${sum+cart.price*cart.num}"/>
				</c:forEach>
				
			</table>

			<div class="Order_price">总价：${sum}元</div>

			<div class="add_orderbox">
				<input name="" type="submit" value="增加订单" class="add_order_but">
			</div>
		</form>
	</div>
	<%@ include file = "_foot.jsp" %>
</body>
</html>
<script>
	function G(id) {
		return document.getElementById(id);
	}
	var map = new BMap.Map("container");
	 map.centerAndZoom("佛山",10); 
	 map.enableScrollWheelZoom(); 
	 function ZoomControl() {
	  this.defaultAnchor = BMAP_ANCHOR_TOP_LEFT;
	  this.defaultOffset = new BMap.Size(10, 10);
	 }
	 ZoomControl.prototype = new BMap.Control();
	 ZoomControl.prototype.initialize = function(map){
	  var div = document.createElement("div");
	  div.innerHTML = '<div id="r-result"><span style="font-size:18px;"></span><input type="text" id="suggestId" size="30" value="" style="width:200px; height:30px" placeholder="输入你的收货地址" /></div><div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>';
	 
	  map.getContainer().appendChild(div);
	  
	  return div;
	 }
	 
	 
	 var myZoomCtrl = new ZoomControl();
	
	 map.addControl(myZoomCtrl);
	 
	 var ac = new BMap.Autocomplete( //建立一个自动完成的对象
	  {"input" : "suggestId"
	  ,"location" : map
	 });
	 
	 ac.addEventListener("onhighlight", function(e) { //鼠标放在下拉列表上的事件
	 var str = "";
	  var _value = e.fromitem.value;
	  var value = "";
	  if (e.fromitem.index > -1) {
	   value = _value.province + _value.city + _value.district + _value.street + _value.business;
	  }
	  str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
	 
	  value = "";
	  if (e.toitem.index > -1) {
	   _value = e.toitem.value;
	   value = _value.province + _value.city + _value.district + _value.street + _value.business;
	  }
	  str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
	  G("searchResultPanel").innerHTML = str;
	 });
	 
	 var myValue;
	 ac.addEventListener("onconfirm", function(e) { //鼠标点击下拉列表后的事件
	 var _value = e.item.value;
	  myValue = _value.province + _value.city + _value.district + _value.street + _value.business;
	  G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
	 
	  setPlace();
	 });
	 var geoc = new BMap.Geocoder();
	 function setPlace(){
	  map.clearOverlays(); 
	
		function myFun() {
			var pp = local.getResults().getPoi(0).point; //获取第一个智能搜索的结果
			map.centerAndZoom(pp, 14);
			map.addOverlay(new BMap.Marker(pp)); //添加标注
			geoc.getLocation(pp, function(rs) {
				var addComp = rs.address;
				document.getElementById("textarea").value = addComp;
				console.log(rs)
			});
		}
		var local = new BMap.LocalSearch(map, { //智能搜索
			onSearchComplete : myFun
		});
		local.search(myValue);
	}

	map.addEventListener("click", function(e) { //给地图添加点击事件
		map.clearOverlays();
		console.log(e);
		var lng = e.point.lng;
		var lat = e.point.lat;
		//创建标注位置
		var pt = new BMap.Point(lng, lat);
		var marker2 = new BMap.Marker(pt); // 创建标注
		map.addOverlay(marker2); // 将标注添加到地图中
		//alert(e.point.lng + "," + e.point.lat);
		geoc.getLocation(pt, function(rs) {
			var addComp = rs.address;
			document.getElementById("textarea").value = addComp;
			console.log(rs)
		});

	});
</script>



