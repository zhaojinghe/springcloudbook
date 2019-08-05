<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<meta name="keywords" content="在线支付案例，支付宝支付Demo，微信支付Demo">
<link rel="stylesheet" href="${ctx}/layui/css/layui.css">
<meta name="description" content="一个Java实现的支付宝微信在线支付在线案例">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black"> 
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
</head>
<body>
<div class="layui-row">
    <div class="layui-col-xs12">
        	<ul class="layui-nav">
			  <li class="layui-nav-item"><a href="/">在线支付</a></li>
			  <li class="layui-nav-item"><a href="${ctx}/order/toOrderListPage">订单查询</a></li>
			  <li class="layui-nav-item"><a href="http://blog.java1234.com/blog/articles/388.html" target="_blank">关于本项目</a></li>
			</ul>
    </div>
</div>
<div class="layui-container">

	
	<div class="layui-row">
	    <div class="layui-col-xs12">
	        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
			  <legend>同步地址</legend>
			</fieldset>
	        ${message}
	    </div>
	</div>
	
</div>
<script src="${ctx}/layui/layui.js"></script>
</body>
</html>