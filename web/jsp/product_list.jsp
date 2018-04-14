<%@ page import="com.itheima.utils.CookieUtils" %>
<%@ page import="com.itheima.service.ProductService" %>
<%@ page import="com.itheima.service.impl.ProductServiceImpl" %>
<%@ page import="com.itheima.domain.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
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


</script>
</head>

<body>


	<!-- 引入header.jsp -->
	<jsp:include page="/jsp/header.jsp"></jsp:include>

	<div class="row" style="width: 1210px; margin: 0 auto;">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/productServlet?method=listAtHome">首页</a></li>
			</ol>
		</div>
		<%--
			<div class="col-md-2" style="text-align:center;height: 200px;padding: 10px 0px;">
				<a href="${pageContext.request.contextPath}/productServlet?method=productInfo&pid=${item.pid}">
					<img src="${pageContext.request.contextPath}/${item.pimage}" width="130" height="130" style="display: inline-block;">
				</a>
				<p><a href="${pageContext.request.contextPath}/productServlet?method=productInfo&pid=${item.pid}" style='color:#666'>${item.pname}</a> </p>
				<p><font color="#8E8E8E" style="font-size: 16px">&yen;${item.shop_price}</font> </p>
			</div>
		--%>

		<c:forEach var="product" items="${pageBean.data}" >
			<div class="col-md-2" style="text-align:center;width:240px ;height: 240px;padding: 20px 0px;">
				<%--<a href="${pageContext.request.contextPath}/productServlet?method=productInfo&pid=${product.pid}">--%>
					<%--<img src="${pageContext.request.contextPath}/${product.pimage}" width="130" height="130" style="display: inline-block;">--%>
				<%--</a>--%>
				<%--<p><a href="${pageContext.request.contextPath}/productServlet?method=productInfo&pid=${product.pid}">--%>
				<%--</a></p>--%>
				<%--<p><font color="#FF0000">商城价：&yen;${product.shop_price}</font> </p>--%>
				<a style="height: 160px" href="${pageContext.request.contextPath}/productServlet?method=productInfo&pid=${product.pid}">
					<img src="${pageContext.request.contextPath}/${product.pimage}" width="130" height="130" style="display: inline-block;">
				</a>
				<P style="height: 20px"></P>
				<p style="height: 30px"><a href="${pageContext.request.contextPath}/productServlet?method=productInfo&pid=${product.pid}" style='color:#666'>${product.pname}</a></p>
				<p style="height: 30px"><font color="#8E8E8E" style="font-size: 16px">&yen;${product.shop_price}</font> </p>
			</div>
		</c:forEach>

	</div>
	<div style="width: 600px; margin: 0 auto; margin-top: 50px;">
		<div class="panel">
			<div id="paginationId" style="font-size:14px;margin:0;display:block;">

				第${pageBean.pageNumber}/${pageBean.totalPage}页&nbsp;
				总项数:${pageBean.totalRecord}&nbsp;
				每页显示:${pageBean.pageSize}&nbsp;

				<c:if test="${pageBean.pageNumber gt 1}">
					<a href="${pageContext.request.contextPath}/productServlet?method=productList&cid=${pageBean.data[0].cid}&pageNumber=1">[首页]
					</a>&nbsp;
					<a href="${pageContext.request.contextPath}/productServlet?method=productList&cid=${pageBean.data[0].cid}&pageNumber=${pageBean.pageNumber-1}">
						[上一页]</a>
				</c:if>&nbsp;

				<c:forEach var="i" begin="1" end="${pageBean.totalPage}">
					<c:if test="${pageBean.pageNumber eq i}">
						第${i}页
					</c:if>
					<c:if test="${pageBean.pageNumber != i}">
						<a href="${pageContext.request.contextPath}/productServlet?method=productList&cid=${pageBean.data[0].cid}&pageNumber=${i}">第${i}页</a>
					</c:if>
				</c:forEach>&nbsp;

				<c:if test="${pageBean.pageNumber lt pageBean.totalPage}">
					<a href="${pageContext.request.contextPath}/productServlet?method=productList&cid=${pageBean.data[0].cid}&pageNumber=${pageBean.pageNumber+1}">[下一页]
					</a>&nbsp;
					<a href="${pageContext.request.contextPath}/productServlet?method=productList&cid=${pageBean.data[0].cid}&pageNumber=${pageBean.totalPage}">
						[尾页]</a>
				</c:if>

			</div>



			<div>
				<nav aria-label="Page navigation">
					<ul class="pagination">
						<c:if test="${!(pageBean.pageNumber gt 1)}">
							<li class="disabled">
								<span aria-hidden="true">&laquo;</span>
							</li>
						</c:if>
						<c:if test="${pageBean.pageNumber gt 1}">
							<li>
								<a href="${pageContext.request.contextPath}/productServlet?method=productList&cid=${pageBean.data[0].cid}&pageNumber=${pageBean.pageNumber-1}" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span>
								</a>
							</li>
						</c:if>

						<c:forEach var="i" begin="1" end="${pageBean.totalPage}">
							<c:if test="${pageBean.pageNumber eq i}">
								<%--<li class="active"><a href="#">${i}</a></li>--%>
								<li class="active"><a href="#">${i}</a></li>
							</c:if>
							<c:if test="${pageBean.pageNumber != i}">
								<li><a href="${pageContext.request.contextPath}/productServlet?method=productList&cid=${pageBean.data[0].cid}&pageNumber=${i}">${i}</a></li>
							</c:if>
						</c:forEach>

						<c:if test="${pageBean.pageNumber lt pageBean.totalPage}">
							<li>
								<a href="${pageContext.request.contextPath}/productServlet?method=productList&cid=${pageBean.data[0].cid}&pageNumber=${pageBean.pageNumber+1}" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
								</a>
							</li>
						</c:if>
						<c:if test="${ !(pageBean.pageNumber lt pageBean.totalPage)}">
							<li class="disabled">
								<span aria-hidden="true">&raquo;</span>
							</li>
						</c:if>
					</ul>
				</nav>

			</div>
		</div>
	</div>


	<div
		style="width: 1210px; margin: 0 auto; padding: 0 9px; border: 1px solid #ddd; border-top: 2px solid #999; height: 246px;">
		<h4 style="width: 50%; float: left; font: 14px/30px 微软雅黑">浏览记录</h4>
		<div style="width: 50%; float: right; text-align: right;">
			<a href="">more</a>
		</div>
		<div style="clear: both;"></div>
		<div style="overflow: hidden;">
		<%--
			<div class="col-md-2" style="text-align:center;height: 200px;padding: 10px 0px;">
				<a href="${pageContext.request.contextPath}/productServlet?method=productInfo&pid=${item.pid}">
					<img src="${pageContext.request.contextPath}/${item.pimage}" width="130" height="130" style="display: inline-block;">
				</a>
				<p><a href="${pageContext.request.contextPath}/productServlet?method=productInfo&pid=${item.pid}" style='color:#666'>${item.pname}</a> </p>
				<p><font color="#8E8E8E" style="font-size: 16px">&yen;${item.shop_price}</font> </p>
			</div>
		--%>
		<c:forEach var="item" items="${prohis}">
			<%--<ul style="list-style: none;">--%>
				<%--<li style="width: 150px; float: left; margin: 0 8px 0 0; padding: 0 18px 15px; text-align: center;">--%>
					<%--<a href="${pageContext.request.contextPath}/productServlet?method=productInfo&pid=${item.pid}">--%>
						<%--<img src="${pageContext.request.contextPath}/${item.pimage}" width="130" height="130" style="display: inline-block;"/>--%>
					<%--</a>--%>
				<%--</li>--%>
			<%--</ul>--%>
			<div class="col-md-2" style="text-align:center;height: 200px;padding: 10px 0px;">
				<a href="${pageContext.request.contextPath}/productServlet?method=productInfo&pid=${item.pid}">
					<img src="${pageContext.request.contextPath}/${item.pimage}" width="130" height="130" style="display: inline-block;"/>
				</a>
				<p><a href="${pageContext.request.contextPath}/productServlet?method=productInfo&pid=${item.pid}" style='color:#666'>${item.pname}</a> </p>
			</div>
		</c:forEach>
	</div>
</div>


<!-- 引入footer.jsp -->
<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>