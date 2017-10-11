<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 13718
  Date: 2017/10/5
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/productServlet?method=listAtHome" >dian</a>
<div>
    <div>${hotList}</div>
    <div>${hotList[0]}</div>
    <div>${hotList[0].pname}</div>
</div>
<c:forEach var="itme" items="${hotList}">
    <div>${itme.pname}</div>
</c:forEach>


<div>

    <div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
        <img src="${pageContext.request.contextPath}/products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
    </div>

    <div class="col-md-10">
        <div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
            <a href="product_info-1.jsp">
                <img src="${pageContext.request.contextPath}/products/hao/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
            </a>
        </div>
        <div class="col-md-2" style="align-content: center;height: auto;padding: 0px;">
        <span>
            <div class="col-md-2" style="text-align: center ;height: 300px;width: 500px;padding: 10px;">
                <a href="${pageContext.request.contextPath}/ProductInfoServlet?method=productInfo&pid=${hotList[0].pid}">
                    <img src="${pageContext.request.contextPath}/${hotList[0].pimage}" >
                </a>
                <p><a href="${pageContext.request.contextPath}/ProductInfoServlet?method=productInfo&pid=${hotList[0].pid}" style='color:#666'>${hotList[0].pname}</a> </p>
                <p><font color="#E4393C" style="font-size: 16px">&yen;${hotList[0].shop_price}</font> </p>
            </div>
        </span>
            <span>
            <div class="col-md-2" style="text-align: center ;height: 300px;width: 500px;padding: 10px;">
                <a href="${pageContext.request.contextPath}/ProductInfoServlet?method=productInfo&pid=${hotList[1].pid}">
                    <img src="${pageContext.request.contextPath}/${hotList[1].pimage}" >
                </a>
                <p><a href="${pageContext.request.contextPath}/ProductInfoServlet?method=productInfo&pid=${hotList[1].pid}" style='color:#666'>${hotList[1].pname}</a> </p>
                <p><font color="#E4393C" style="font-size: 16px">&yen;${hotList[1].shop_price}</font> </p>
            </div>
        </span>
            <span>
            <div class="col-md-2" style="text-align: center ;height: 300px;width: 500px;padding: 10px;">
                <a href="${pageContext.request.contextPath}/ProductInfoServlet?method=productInfo&pid=${hotList[2].pid}">
                    <img src="${pageContext.request.contextPath}/${hotList[2].pimage}" >
                </a>
                <p><a href="${pageContext.request.contextPath}/ProductInfoServlet?method=productInfo&pid=${hotList[2].pid}" style='color:#666'>${hotList[2].pname}</a> </p>
                <p><font color="#E4393C" style="font-size: 16px">&yen;${hotList[2].shop_price}</font> </p>
            </div>
         </span>
        </div>

    </div>





</div>


</body>
</html>
