<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />


<style>
body {
	margin-top: 20px;
	margin: 0 auto;
	width: 100%;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
<script>
	function subForm() {
		document.getElementById("form1").submit();
    }

    <%--$(function () {--%>
		<%--$("#paginationId").pagination({--%>
			<%--total:'${pageBean.pageSize}',--%>
			<%--pageSize:'${pageBean.pageSize}',--%>
			<%--pageNumber:'${param.pageNumber}',--%>
			<%--layout:['first','prev','sep','links','sep','next','last','sep','maunal'],--%>
			<%--beforePageText:'当前页',--%>
			<%--afterPageText:'页，共{pages}页',--%>
			<%--display:'当前显示{from}到{to}条，共{total}条记录',--%>
			<%--onSelectPage:function (pageNumber,pageSize) {--%>
			    <%--location.href = "${pageContext.request.contextPath}/ProductControl?cid=${param.cid}$pageNmuber="+pageNumber;--%>


            <%--}--%>

		<%--})--%>
    <%--})--%>

</script>
</head>

<body>


	<!-- 引入header.jsp -->
	<jsp:include page="/jsp/header.jsp"></jsp:include>


	<div class="row" style="width: 1210px; margin: 0 auto;">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="#">首页</a></li>
			</ol>
		</div>

		<%--<c:forEach var="product" items="${requestScope.pageBean}" >--%>
			<%--<div class="col-md-2" style="height:240px;">--%>
				<%--<a href="${pageContext.request.contextPath}/ProductInfoServlet?pid=${product.pid}">--%>
					<%--<img src="${pageContext.request.contextPath}/${product.pimage}">--%>
				<%--</a>--%>
				<%--<p><a href="${pageContext.request.contextPath}/ProductInfoServlet?pid=${product.pid}">--%>

				<%--</a></p>--%>
				<%--<p><font color="#FF0000">商城价：&yen;${product.shop_price}</font> </p>--%>
			<%--</div>--%>
		<%--</c:forEach>--%>
		<div class="col-md-2" style="height:240px;">
			<a href="${pageContext.request.contextPath}/ProductInfoServlet?pid=${product.pid}">
				<img src="${pageContext.request.contextPath}/${product.pimage}">
			</a>
			<p><a href="${pageContext.request.contextPath}/ProductInfoServlet?pid=1">

			</a></p>
			<p><font color="#FF0000">商城价：&yen;100${product.shop_price}</font> </p>
		</div>



	</div>

	<%--<div style="width: 600px; margin: 0 auto; margin-top: 50px;">--%>
		<%--<div class="panel">--%>
			<%--<div id="paginationId" style="font-size:14px;margin:0;display:block;"></div>--%>
		<%--</div>--%>
	<%--</div>--%>

	<!--商品浏览记录-->
	<div
		style="width: 1210px; margin: 0 auto; padding: 0 9px; border: 1px solid #ddd; border-top: 2px solid #999; height: 246px;">

		<h4 style="width: 50%; float: left; font: 14px/30px 微软雅黑">浏览记录</h4>
		<div style="width: 50%; float: right; text-align: right;">
			<a href="">more</a>
		</div>
		<div style="clear: both;"></div>

		<div style="overflow: hidden;">

			<ul style="list-style: none;">
				<li
					style="width: 150px; height: 216; float: left; margin: 0 8px 0 0; padding: 0 18px 15px; text-align: center;"><img
					src="${pageContext.request.contextPath}/products/1/cs10001.jpg" width="130px" height="130px" /></li>
			</ul>

		</div>
	</div>


	<!-- 引入footer.jsp -->
	<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>