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
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
<script type="text/javascript">

</script>
</head>

<body>
	<!-- 引入header.jsp -->
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div
				style="border: 1px solid #e4e4e4; width: 930px; margin-bottom: 10px; margin: 0 auto; padding: 10px; margin-bottom: 10px;">
				<a href="./index.jsp">首页</a>&nbsp;&nbsp;&gt;
				<a href="${pageContext.request.contextPath}/productServlet?method=productList&cid=${product.cid}">${product.cid}</a>&nbsp;&nbsp;&gt;
				<a>${product.pname}</a>
			</div>

			<div style="text-align: center;margin: 0 auto; width: 950px;">
				<div class="col-md-6" >
					<img style="opacity: 1;padding: 100px 50px;" title=""
						class="medium"
						src="${pageContext.request.contextPath}/${product.pimage}">
				</div>
				<div class="col-md-6">
					<div>
						<strong>商品名称：${product.pname}</strong>
					</div>
					<div
						style="border-bottom: 1px dotted #dddddd; width: 350px; margin: 10px 0 10px 0;">
						<div>商品编号：${product.pid}</div>
					</div>
					<div style="margin: 10px 0 10px 0;">
						亿家价: <strong style="color: #ef0101;">￥：${product.market_price}/份</strong> 参 考 价：
						<del>￥${product.shop_price}元/份</del>
					</div>

					<div style="margin: 10px 0 10px 0;">
						促销: <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)"
							style="background-color: #f07373;">限时抢购</a>
					</div>

					<div style="padding: 10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #fffee6;">
						<div style="margin: 5px 0 10px 0;">${product.pname}</div>

						<form id="form1" action="${pageContext.request.contextPath}/cartServlet?method=cartAdd" method="post">
							<div style="border-bottom: 1px solid #faeac7; margin-top: 20px; padding-left: 10px;">购买数量:
								<input id="quantity" name="count" value="1" maxlength="4" size="10" type="text">
								<input type="hidden" name="pid" value="${product.pid}">
							</div>
							<div style="margin: 20px 0 10px 0;; text-align: center;">
								<input style="background: url('${pageContext.request.contextPath}/images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0); height: 36px; width: 127px;" value="加入购物车" type="submit">&nbsp;收藏商品
							</div>
						</form>

						<a href="${pageContext.request.contextPath}/jsp/cart.jsp">点击查看购物车</a>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<div style="width: 950px; margin: 0 auto;">
				<div style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
					<strong>商品介绍</strong>
				</div>

				<div>
					<img src="${pageContext.request.contextPath}/${product.pimage}" width="130" height="130" style="display: inline-block;">
				</div>

				<div
					style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
					<strong>商品参数</strong>
				</div>
				<div style="margin-top: 10px; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th colspan="2">基本参数</th>
							</tr>
							<tr>
								<th width="10%">级别</th>
								<td width="30%">标准</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div style="background-color: #d3d3d3; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th><strong>商品评论</strong></th>
							</tr>
							<tr class="warning">
								<th>暂无商品评论信息 <a>[发表商品评论]</a></th>
							</tr>
						</tbody>
					</table>
				</div>

				<div style="background-color: #d3d3d3; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th><strong>商品咨询</strong></th>
							</tr>
							<tr class="warning">
								<th>暂无商品咨询信息 <a>[发表商品咨询]</a></th>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>