<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/layouts/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<meta name="keywords" content="在线支付案例，支付宝支付Demo，微信支付Demo">
<link rel="stylesheet" href="${ctx}/layui/css/layui.css">
<meta name="description" content="一个Java实现的支付宝微信在线支付在线案例，Java知识分享网出品，作者 Java1234_小锋老师。">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black"> 
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
</head>
<body>
<div class="layui-container">
	
	<#include "/common/head.ftl">
	
	<div class="layui-row">
	    <div class="layui-col-xs12">
	        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
			  <legend>在线支付</legend>
			</fieldset>
	        <form class="layui-form" method="post" action="/alipay/pay">
			    <div class="layui-form-item" pane="">
			        <label class="layui-form-label">支付金额:</label>
			        <input type="hidden" id="totalMoney" name="totalMoney"/>
				    <div class="layui-input-block">
				      <input type="radio" name="productId" value="1" title="09元-请锋哥喝杯奶茶" >
				    </div>
				    <div class="layui-input-block">
				      <input type="radio" name="productId" value="2" title="29元-请锋哥吃肯德基" checked="">
				    </div>
				    <div class="layui-input-block">
				      <input type="radio" name="productId" value="3" title="49元-请锋哥吃顿饭">
				    </div>
			    </div>
			  
			  
			     <div class="layui-form-item">
				    <label class="layui-form-label">支付人:</label>
				    <div class="layui-input-block">
				      <input type="text" name="nickName" lay-verify="required" placeholder="请输入您的大名或者昵称" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  
				  <div class="layui-form-item">
				    <label class="layui-form-label">QQ:</label>
				    <div class="layui-input-block">
				      <input type="text" name="qq" lay-verify="required|number"  placeholder="请输入您的QQ号" autocomplete="off" class="layui-input">
				    </div>
				  </div>
				  
				  <div class="layui-form-item layui-form-text">
				    <label class="layui-form-label">留言:</label>
				    <div class="layui-input-block">
				      <textarea id="message" name="message" placeholder="请输入留言内容" class="layui-textarea"></textarea>
				    </div>
				  </div>
				  
				  <div class="layui-form-item">
				    <label class="layui-form-label">支付方式:</label>
				    <div class="layui-input-block">
				      <input type="radio" name="way" value="支付宝" title="支付宝" checked="">
				      <input type="radio" name="way" value="微信" title="微信">
				    </div>
				  </div>
				  
				  
				  <div class="layui-form-item">
				    <div class="layui-input-block">
				      <button class="layui-btn" lay-submit="" lay-filter="demo1">支付提交</button>
				    </div>
				  </div>
  
	        </form>
	    </div>
	</div>
	
  </div>
</div>
<script src="${ctx}/layui/layui.js"></script> 
<script>
layui.use('element', function(){
  var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
  
  
});
</script>
<script>
layui.use('form', function(){
  
  var form = layui.form;
 
   //监听提交
  form.on('submit(demo1)', function(data){
    if(data.field.way=='支付宝'){
    	data.form.action="/alipay/pay";
    }else if(data.field.way=='微信'){
    	data.form.action="/weixinpay/pay";
    }
    return true;
  });

});
</script>

</body>
</html>