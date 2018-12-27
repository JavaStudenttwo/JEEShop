<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<script type="text/javascript">
	/**页面加载完成后执行*/
    $(function () {
        /**
         * creater:litiecheng
         * createDate:2017-10-5
         * discription:页面加载完成后，使用AJAX查询并在首页显示商品(每次刷新页面后都会执行)
         * indetail:
         *
         */
        $.post(
            "${pageContext.request.contextPath}/productServlet?method=category",
            function (data) {
                $.each(data,function (i,n) {
                    $("#menu").append("<li value=''>" + "<a href='${pageContext.request.contextPath}/productServlet?method=productList&cid="+n.cid+"'>"+n.cname+"</a></li>");
                })
			},
            "json"
        )

        /**
         * creater:litiecheng
         * createDate:2017-10-5
         * discription:AJAX异步根据关键字查询商品
         * indetail:
         *
         */
        $("#search").keyup(function () {
            var url = "${pageContext.request.contextPath}/productServlet?method=queryByKeyword";
            var word = $(this).val();
            var params = {"word":word};
            if(word == ""){
                $("#completeShow").slideUp(200);
                return false;
            }
            $.post(
                url,
                params,
                function (data) {
                    $("#completeShow1").html("<ul id='itemul' class='list-group'></ul>");
                    for(var i=0 ;i<data.length;i++){
                        var product = data[i];
                        var str = ""+product.pname;
                        str = highlight(word,str);
                        $("#itemul").append("<li class='list-group-item'>" +
							"<a href='${pageContext.request.contextPath}/productServlet?method=productInfo&pid="+product.pid+"'>"+str+"</a></li>")
                        $("#completeShow1").show();
                    }
                },
                "json"
			)
        }).focus(function () {
            if($("#completeShow li").size()>0){
                $("#completeShow").show();
			}
        }).click(function () {
            return false;
        })

		function highlight(word,str) {
            var start = "";
            var end =str;
            for(var i=0;i<word.length;i++){
                var w = word.substring(i,i+1);
                var index = end.indexOf(w);
                start += end.substring(0,index);
                start += "<font color='red'>"+w+"</font>";
                end = end.substring(index +1,end.length);
            }
			start+=end;
			return start;
        }

        $(document).click(function () {
			$("#completeShow").slideUp(200);
        });

    });

</script>

<div class="bs-docs-header" id="content" tabindex="-1" style="background:#ffCC33">
	<div class="container">
		<h1>JEE电子商城</h1>
		<h5>java练习项目，GitHub链接：<a href="https://github.com/JavaStudenttwo/HeimaShop">JEE商城</a></h5>
	</div>
</div>

<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4" style="text-align:right;padding: 10px 0px;">
		<ol class="nav nav-tabs">
			<c:if test="${empty loginUser}">
				<li role="presentation"><a href="${pageContext.request.contextPath}/jsp/login.jsp">登录</a></li>
				<li role="presentation"><a href="${pageContext.request.contextPath}/jsp/register.jsp">注册</a></li>
			</c:if>
			<li role="presentation"><a href="${pageContext.request.contextPath}/jsp/cart.jsp">购物车</a></li>
			<c:if test="${not empty loginUser}">

				<li role="presentation"><a href="${pageContext.request.contextPath}/orderServlet?method=findByUid">我的订单</a> </li>
				<li role="presentation"><a href="${pageContext.request.contextPath}/userServlet?method=logout">退出</a></li>

			</c:if>

		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse" >
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/productServlet?method=listAtHome">导航栏</a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" id="menu"></ul>
				<form class="navbar-form navbar-right" role="search" id="form1" action="${pageContext.request.contextPath}/productServlet?method=productSearch" method="post">
					<div class="form-group">
						<input id="search" type="text" class="form-control" placeholder="Search" name="word">
					</div>
					<button id="submit" type="submit" class="btn btn-default">查询</button>
					<div id="completeShow">
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu3">
						</ul>
					</div>
				</form>
			</div>
		</div>
	</nav>
</div>



