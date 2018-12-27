<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/js/public.js"></script>
<script type="text/javascript">
			function addProduct(){
				window.location.href = "${pageContext.request.contextPath}/adminProductServlet?method=toAdd";
			}
		</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/user/list.jsp"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>订单管理</strong>
					</TD>
				</tr>
				<%--<tr>--%>
					<%--<td class="ta_01" align="right">--%>
						<%--<button type="button" id="add" name="add" value="添加"--%>
							<%--class="button_add" onclick="addProduct()">--%>
							<%--&#28155;&#21152;</button>--%>
					<%--</td>--%>
				<%--</tr>--%>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="18%">序号</td>
								<td align="center" width="17%">下单时间</td>
								<td align="center" width="17%">订单总金额</td>
								<td align="center" width="17%">订单状态</td>
								<td align="center" width="17%">送货地址</td>
								<td width="7%" align="center">删除</td>
								<td width="7%" align="center">编辑</td>
							</tr>
							<c:forEach var="item" varStatus="status" items="${pageBean.data}">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="18%">${status.count }</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${item.ordertime}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">${item.total}</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">
										<c:if test="${item.state == 1}">
											未付款
										</c:if>
										<c:if test="${item.state == 2}">
											发货
										</c:if>
										<c:if test="${item.state == 3}">
											未确认收费
										</c:if>
										<c:if test="${item.state == 4}">
											订单结束
										</c:if>
									</td>
									<td style="CURSOR: hand; HEIGHT: 22px" align="center"
										width="17%">
										${item.address}
									</td>
									<td align="center" style="HEIGHT: 22px"><a
										href="${ pageContext.request.contextPath }/adminOrderServlet?method=orderEdit&pid=${item.oid}">
											<img src="${pageContext.request.contextPath}/images/i_edit.gif"
											border="0" style="CURSOR: hand">
									</a></td>
									<td align="center" style="HEIGHT: 22px">
										<a href="${pageContext.request.contextPath}/adminOrderServlet?method=orderDelete&pid=${item.oid}">
											<img src="${pageContext.request.contextPath}/images/i_del.gif"
											width="16" height="16" border="0" style="CURSOR: hand">
									</a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>

	<table>
		<%--<tr onmouseover="this.style.backgroundColor = 'white'"
			onmouseout="this.style.backgroundColor = '#F5FAFE';">
			<td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">
				<div id="paginationId" style="font-size:14px;margin:0;display:block;">

					第${pageBean.pageNumber}/${pageBean.totalPage}页&nbsp;
					总项数:${pageBean.totalRecord}&nbsp;
					每页显示:${pageBean.pageSize}&nbsp;

					<c:if attempt="${pageBean.pageNumber gt 1}">
						<a href="${pageContext.request.contextPath}/adminProductServlet?method=productList&pageNumber=1">[首页]
						</a>&nbsp;
						<a href="${pageContext.request.contextPath}/adminProductServlet?method=productList&pageNumber=${pageBean.pageNumber-1}">
							[上一页]</a>
					</c:if>&nbsp;

					<c:forEach var="i" begin="1" end="${pageBean.totalPage}">
						<c:if attempt="${pageBean.pageNumber eq i}">
							第${i}页
						</c:if>
						<c:if attempt="${pageBean.pageNumber != i}">
							<a href="${pageContext.request.contextPath}/adminProductServlet?method=productList&pageNumber=${i}">第${i}页</a>
						</c:if>
					</c:forEach>&nbsp;

					<c:if attempt="${pageBean.pageNumber lt pageBean.totalPage}">
						<a href="${pageContext.request.contextPath}/adminProductServlet?method=productList&pageNumber=${pageBean.pageNumber+1}">[下一页]
						</a>&nbsp;
						<a href="${pageContext.request.contextPath}/adminProductServlet?method=productList&pageNumber=${pageBean.totalPage}">
							[尾页]</a>
					</c:if>
				</div>
			</td>
		</tr>--%>


	</table>

</body>
</HTML>

