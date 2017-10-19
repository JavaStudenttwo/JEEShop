<%--
  Created by IntelliJ IDEA.
  User: CycloneKid sk18810356@gmail.com
  Date: 2017/10/14 9:42
  Description: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
    <title>转账页面</title>

</head>
<body>
<br/>
<br/>
<br/>
<br/>
<br/>


<div class="container">
    <form action="${pageContext.request.contextPath}/orderServlet?method=transfer" method="post">
        <div class="form-group">
            <label for="username">付款人：</label>
            <input type="text" class="form-control" id="username" name="name" placeholder="Text input" value="${name}">
        </div>
        <div class="form-group">
            <label for="to">收款人：</label>
            <input type="text" class="form-control" id="to" name="to" placeholder="Text input" value="${to}">
        </div>
        <div class="form-group">
            <label for="money">转账金额：</label>
            <input type="text" class="form-control" id="money" name="money" placeholder="Text input" value="${money}">
        </div>
        <button type="submit" class="btn btn-default">转账</button>
    </form>
</div>




</body>
</html>
