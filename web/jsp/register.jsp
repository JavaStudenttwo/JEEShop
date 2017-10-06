<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>
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

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>

<script type="text/javascript">

    /**
     * creater:litiecheng
     * createDate:2017-9-2
     * discription:AJAX异步校验用户名是否可用
     * indetail:使用AJAX校验用户名是否存在，如果存在，则在用户名输入框的下方提示用户名存在，不存在则提示可用
     *
     */
	$(function () {
	    $("#username").blur(function () {
			var value = $(this).val();
			if(value!=null){
			    $.get(
                    "${pageContext.request.contextPath}/userServlet?method=checkUserName",
                    {"username":value},
					function (data) {
                        var isExist = data.isExist;
			        	if(isExist){
			        	    usernameInfo = "该用户名已经存在";
							$("#usernameInfo").css("color","red");
//                            $("#regBut").attr("disabled",true);
                            $("#regBut").disabled = true;
						}else{
                            usernameInfo = "该用户名可以使用";
                            $("#usernameInfo").css("color","green");
//                            $("#regBut").attr("disabled",false);
                            $("#regBut").disabled = false;
						}
						$("#usernameInfo").html(usernameInfo);
					},
					"json"
				);
			}
        });

        /**
         * creater:litiecheng
         * createDate:2017-10-4
         * discription:AJAX异步校验验证码
         * indetail:
         *
         */
	    $("#confirmimg").blur(function ( ) {
            var value = $(this).val();
            if(value!=null){
                $.post(
                    "${pageContext.request.contextPath}/userServlet?method=checkValidatecode",
                    {"validatecode":value},
                    function (data) {
                        var boole = data.boole;
                        if(boole){
                            validatecodeInfo = "验证码正确";
                            $("#validatecodeInfo").css("color","green");
//                            $("#regBut").attr("disabled",true);
                            $("#regBut").disabled = true;
                        }else{
                            validatecodeInfo = "验证码错误";
                            $("#validatecodeInfo").css("color","red");
//                            $("#regBut").attr("disabled",false);
                            $("#regBut").disabled = false;
                        }
                        $("#validatecodeInfo").html(validatecodeInfo);
                    },
                    "json"
                );
            }
        })
    });

    /**
     * creater:litiecheng
     * createDate:2017-9-4
     * discription:更换图片验证码
     * indetail:
     *
     */
	function changeimg(obj) {
	    obj.src="${pageContext.request.contextPath}/jsp/validatecode.jsp?time="+new Date().getTime();
    }
</script>

</head>
<body>
	<!-- 引入header.jsp -->
	<jsp:include page="/jsp/header.jsp"></jsp:include>
	<div class="container"
		style="width: 100%; background: url('${pageContext.request.contextPath}/image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>会员注册</font>USER REGISTER
				<form class="form-horizontal" style="margin-top: 5px;" action="${pageContext.request.contextPath}/userServlet?method=register" method="post">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username" name="username"
								placeholder="请输入用户名">
							<span id="usernameInfo" ></span>
 						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="inputPassword3" name="password"
								placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="confirmpwd"
								placeholder="请输入确认密码">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="inputEmail3" name="email"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="usercaption" name="name"
								placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline">
								<input type="radio" name="sex" id="inlineRadio1" value="option1">
								男
							</label>
							<label class="radio-inline">
								<input type="radio" name="sex" id="inlineRadio2" value="option2">
								女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label  for="date" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-6">
							<input id="date" type="date" class="form-control" name="birthday">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmimg" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-3">
							<input id="confirmimg" type="text" class="form-control" name="validatecode">
							<span id="validatecodeInfo" ></span>
						</div>
						<div class="col-sm-2">
							<img src="${pageContext.request.contextPath}/jsp/validatecode.jsp" onclick="changeimg(this)" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input id="regBut" type="submit" width="100" value="注册" name="submit"
								style="background: url('${pageContext.request.contextPath}/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>




