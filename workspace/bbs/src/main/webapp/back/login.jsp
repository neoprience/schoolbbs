<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE HTML>
<html>
<head>
	<title>后内容管理系统-登陆</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="/common/common.jsp" %>
 	<style>

        .large-header{
            overflow: hidden;
            background-size: cover;
            position: absolute;
            top: 0px;
            left: 0px;
            width: 100%;
            height: 100%;
            z-index: -1;
            display: block;
        }
        .login{
            width: 98%;
            text-align: center;
            position: absolute;
            top:35%;
        }
        .l_p{
            margin: -1px;
        }
        .l_p:last-child{
            margin-top:20px;
        }
        .l_p input{
            width: 280px;
            height: 36px;
            outline: none;
            background: rgba(1, 1, 1,0.6);
            border: 1px solid #32231e;
            color: #fff;
            text-indent: 10px;
        }
        .l_p a{
            display: inline-block;
            width: 280px;
            height: 34px;
            background: rgba(1, 1, 1,0.6);
            border: 1px solid #32231e;
            color: #e5e5e5;
            line-height: 34px;
            text-decoration: none;
            border-radius: 5px;
        }
		.reg{
			    margin-left: 215px;
				color: #000;
				text-decoration: none;
				transition:1s all ease;
		}
		.reg:hover{
			color:#666;
			transition:1s all ease;
		}
		input:-webkit-autofill {
			-webkit-box-shadow: 0 0 0px 1000px white inset !important;
			-webkit-text-fill-color: #333;
		}
		h1{
			font-size:24px;
			margin:10px;
			padding:10px;
		}
    </style>
</head>
<body>
<div class="container">
    <div class="content">
        <div id="large-header" class="large-header" style="background: url('/images/1.jpg');">
            <canvas id="demo-canvas"></canvas>
        </div>
        <div class="login">
            <h1>后台内容管理系统</h1>
            <form action="/admin/login">
                <p class="l_p"><input type="text" id="username" value="" name="username" placeholder="用户名/邮箱/手机" /></p>
                <p class="l_p"><input type="password" id="password" value="" name="password" placeholder="请输入密码"/></p>
                <p class="l_p" style=" margin-top:20px;"><a href="javascript:void(0)" onclick="login()">登录</a></p>
            </form>
        </div>
    </div>
</div>
<script src="/js/login.js"></script>
<script src="/js/ec.js"></script>
<script >
	function login(){
		//获取页面数据
		var userName=$("form input[name=username]").val();
		var userPassword=$("form input[name=password]").val();
		if(userName==""){
			$("form table tr:eq(0) td span").html("用户名不能为空");
			return false;
		}
		if(userPassword==""){
			$("form table tr:eq(1) td span").html("密码不能为空");
			return false;
		}
		//发送异步请求
		$.ajax({
			url:"/admin/login",
			type:"get",
			data:{"userName":userName,"userPassword":userPassword},
			dataType:"json",
			success:function(result){
				//result是服务端返回的数据
				if(result.status==1){
					//window.location.href="index.html";
					window.location.href="/";
					
				}else if(result.status==0){
					alert(result.msg);
				}
			},
			error:function(){
				alert("请求失败!");
			}
		});
		
		return false;
	}
</script>
</body>
</html>