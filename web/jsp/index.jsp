<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>JEE电子商城首页</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
  <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
  <script>
  </script>
</head>

<body>
<div class="container-fluid">

  <!-- 引入header.jsp -->
  <jsp:include page="header.jsp"></jsp:include>
  </div>
    <span>${el}</span>
  </div>


      <!-- 轮播图 -->
      <div class="container-fluid">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
          <!-- 轮播图的中的小点 -->
          <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
          </ol>
          <!-- 轮播图的轮播图片 -->
          <div class="carousel-inner" role="listbox">
            <div class="item active">
              <img src="${pageContext.request.contextPath}/img/1.jpg">
              <div class="carousel-caption">
                <!-- 轮播图上的文字 -->
              </div>
            </div>
            <div class="item">
              <img src="${pageContext.request.contextPath}/img/2.jpg">
              <div class="carousel-caption">
                <!-- 轮播图上的文字 -->
              </div>
            </div>
            <div class="item">
              <img src="${pageContext.request.contextPath}/img/3.jpg">
              <div class="carousel-caption">
                <!-- 轮播图上的文字 -->
              </div>
            </div>
          </div>
          <!-- 上一张 下一张按钮 -->
          <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
      </div>


  <!-- 热门商品 -->
  <div class="container-fluid " style="padding: 10px 0px;">
    <div class="col-md-12 bg-info">
      <h2>热门商品&nbsp;&nbsp;<small>为您推荐</small></h2>
    </div>
    <div class="col-md-12">
      <c:forEach var="item" items="${hotList}">
        <div class="col-md-2" style="text-align:center;height: 200px;padding: 10px 0px;">
          <a href="${pageContext.request.contextPath}/productServlet?method=productInfo&pid=${item.pid}">
            <img src="${pageContext.request.contextPath}/${item.pimage}" width="130" height="130" style="display: inline-block;">
          </a>
          <p><a href="${pageContext.request.contextPath}/productServlet?method=productInfo&pid=${item.pid}" style='color:#666'>${item.pname}</a> </p>
          <p><font color="#8E8E8E" style="font-size: 16px">&yen;${item.shop_price}</font> </p>
        </div>
      </c:forEach>
    </div>
  </div>

<%--
  <%
    pageContext.setAttribute("p1name","page");
    String rname = (String) request.getAttribute("rname");
    out.println(rname);
    request.setAttribute("pname","lilisiq");

    application.setAttribute("cname","xiaomingq");
  %>

  <%=application.getAttribute("cname")%>
  <%=request.getAttribute("rname")%>
  <%=session.getAttribute("sname")%>
  ${cname}
  ${rname}
  ${sname}
  ${pname}


--%>

  <!-- 广告条 -->
  <div class="container-fluid">
    <img src="${pageContext.request.contextPath}/products/hao/ad.jpg" width="100%"/>
  </div>


  <!-- 最新商品 -->
  <div class="container-fluid" style="padding: 10px 0px;">
    <div class="col-md-12 bg-info">
      <h2>最新商品&nbsp;&nbsp;<small>为您推荐</small></h2>
    </div>
    <div class="col-md-12">
      <c:forEach var="p" items="${newList}">
        <div class="col-md-2" style="text-align:center;height: 200px;padding: 10px 0px;" >
          <a href="${pageContext.request.contextPath}/productServlet?method=productInfo&pid=${p.pid}">
            <img src="${pageContext.request.contextPath}/${p.pimage}" width="130" height="130" style="display: inline-block;">
          </a>
          <p><a class="productInfo" href="${pageContext.request.contextPath}/productServlet?method=productInfo&pid=${p.pid}" style='color:#666'>${p.pname}</a> </p>
          <p><font color="#8E8E8E" style="font-size: 16px">&yen;${p.shop_price}</font> </p>
        </div>
      </c:forEach>

    </div>
  </div>
  <!-- 引入footer.jsp -->
  <jsp:include page="footer.jsp"></jsp:include>

</div>
</body>


</html>