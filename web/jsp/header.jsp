<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<script type="text/javascript">
    $(function () {
        $("#search").keyup(function () {

            var url = "${pageContext.request.contextPath}/productFindByword?method=checkName";
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
                    $("#completeShow").html("<ul id='itemul' class='list-group'></ul>");
                    for(var i=0 ;i<data.length;i++){
                        var product = data[i];
                        var str = ""+product.pname;
                        str = highlight(word,str);
                        $("#itemul").append("<li class='list-group-item'><a href='#'>"+str+"</a></li>")
                        $("#completeShow").show();
                    }
                }),
                "json"
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


    $(function () {
		$.post(
            "${pageContext.request.contextPath}/category",

			function (data) {
                $.each(data,function (i,n) {
                    $("#menu").append("<li value=''><a href='#'>"+n.cname+"</a></li>");
                })

            },
			"json"

		)

    })
	<%--$(function () {--%>
        <%--$.post(--%>
            <%--"${pageContext.request.contextPath}/IndexServlet",--%>

            <%--function (data){--%>
                <%--var p = data.split("#");--%>
                <%--var hotlist;--%>
                <%--var newlist;--%>
                <%--p[0] = hotlist;--%>
                <%--p[1] = newlist;--%>
                <%--alert(hotlist);--%>
                <%--alert(newlist);--%>

            <%--},--%>
            <%--"json"--%>
        <%--)--%>

    <%--})--%>



</script>



<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="../img/logo2.png" />
	</div>
	<div class="col-md-5">
		<img src="../img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<c:if test="${empty loginUser}">
				<li><a href="login.jsp">登录</a></li>
				<li><a href="register.jsp">注册</a></li>
			</c:if>
			<li><a href="cart.jsp">购物车</a></li>
			<c:if test="${not empty loginUser}">
				欢迎：${loginUser.name},
				<li><a href="${pageContext.request.contextPath}/order_list.jsp">我的订单</a> </li>
				<li><a href="${pageContext.request.contextPath}/userlogout">退出</a></li>
			</c:if>

		</ol>
	</div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/IndexServlet">首页</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" id="menu">

				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input id="search" type="text" class="form-control" placeholder="Search">
					</div>
					<button id="submit" type="submit" class="btn btn-default">Submit</button>
					<div id="completeShow">


					</div>

				</form>
			</div>
		</div>
	</nav>
</div>