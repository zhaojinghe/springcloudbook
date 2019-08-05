package com.bjpowernode.controller;


import java.io.IOException;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.bjpowernode.po.OsOrder;
import com.bjpowernode.po.OsOrderStatus;
import com.bjpowernode.po.OsUser;
import com.bjpowernode.service.OsOrderService;
import com.bjpowernode.util.DeviceUtil;
import com.bjpowernode.util.StringUtil;
import com.bjpowernode.vo.AlipayProperties;


/**
 * 支付宝支付Controller
 * @author Administrator
 * #支付宝支付配置
*/
@Controller
@RequestMapping("/alipay")
public class AlipayController {
	
	private static Logger logger=Logger.getLogger(AlipayController.class);
	
	private AlipayProperties alipayProperties=new AlipayProperties();
	 @Autowired
	 private OsOrderService osOrderService;

	/**
	 * 支付请求
	 * @param alipayTradeWapPayModel
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/pay")
	public void pay(@RequestParam("trade_no")String trade_no,
			@RequestParam("totalmoney")String totalmoney,
			HttpServletRequest request,
			HttpServletResponse response,OsOrder order) throws ServletException, Exception{
				
		logger.debug("=========trade_no========="+trade_no);
		logger.debug("=========totalmoney========="+totalmoney);
		
		logger.debug("=========alipayProperties.getUrl()========="+alipayProperties.getUrl());
		
		logger.debug("=========order========="+order.getOrderNumber());
			String form=""; // 生成支付表单
			
			String userAgent = request.getHeader("user-agent");
			
			// 封装请求客户端
			AlipayClient client=new DefaultAlipayClient(alipayProperties.getUrl(), alipayProperties.getAppid(), alipayProperties.getRsa_private_key(), alipayProperties.getFormat(), alipayProperties.getCharset(), alipayProperties.getAlipay_public_key(), alipayProperties.getSigntype());
			
			if(DeviceUtil.isMobileDevice(userAgent)){ // 移动设备
				AlipayTradeWapPayRequest alipayRequest=new AlipayTradeWapPayRequest();
				alipayRequest.setReturnUrl(alipayProperties.getReturn_url());
				alipayRequest.setNotifyUrl(alipayProperties.getNotify_url());
				AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
				model.setProductCode("FAST_INSTANT_TRADE_PAY"); // 设置销售产品码
				model.setOutTradeNo(trade_no); // 设置订单号
				model.setSubject("订单测试"); // 订单名称
				model.setTotalAmount(totalmoney); // 支付总金额
				model.setBody("测试的商品"); // 设置商品描述
				alipayRequest.setBizModel(model);
				form=client.pageExecute(alipayRequest).getBody(); // 生成表单
			}else{
				// 支付请求
				AlipayTradePagePayRequest alipayRequest=new AlipayTradePagePayRequest();
				alipayRequest.setReturnUrl(alipayProperties.getReturn_url());
				alipayRequest.setNotifyUrl(alipayProperties.getNotify_url());
				AlipayTradePayModel model=new AlipayTradePayModel();
				model.setProductCode("FAST_INSTANT_TRADE_PAY"); // 设置销售产品码
				model.setOutTradeNo(trade_no); // 设置订单号
				model.setSubject("订单测试"); // 订单名称
				model.setTotalAmount("1"); // 支付总金额
				model.setBody("测试的商品"); // 设置商品描述
				alipayRequest.setBizModel(model);
				
				form=client.pageExecute(alipayRequest).getBody(); // 生成表单
			}
				
			response.setContentType("text/html;charset=" + alipayProperties.getCharset()); 
			response.getWriter().write(form); // 直接将完整的表单html输出到页面 
			response.getWriter().flush(); 
			response.getWriter().close();
	}
	
	/**
	 * 支付宝服务器同步通知页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/returnUrl")
	public ModelAndView returnUrl(HttpServletRequest request)throws Exception{
		ModelAndView mav=new ModelAndView();
		mav.addObject("title", "同步通知地址");
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
			System.out.println("name:"+name+",valueStr:"+valueStr);
		}
		
		boolean signVerified = AlipaySignature.rsaCheckV1(params, alipayProperties.getAlipay_public_key(), alipayProperties.getCharset(), alipayProperties.getSigntype()); //调用SDK验证签名
		logger.info("=======================================returnUrl"+signVerified);
		//——请在这里编写您的程序（以下代码仅作参考）——
		if(signVerified) {
			mav.addObject("message", "非常感谢，祝您生活愉快！");
		}else {
			mav.addObject("message", "验签失败");
		}
		mav.setViewName("/pay/returnUrl");
		return mav;
	}
	
	/**
	 * 支付宝服务器异步通知
	 * @param request
	 * @return
	 */
	@RequestMapping("/notifyUrl")
	public void notifyUrl(HttpServletRequest request)throws Exception{
		logger.info("notifyUrl");
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			params.put(name, valueStr);
			System.out.println("name:"+name+",valueStr:"+valueStr);
		}
		
		boolean signVerified = AlipaySignature.rsaCheckV1(params, alipayProperties.getAlipay_public_key(), alipayProperties.getCharset(), alipayProperties.getSigntype()); //调用SDK验证签名
		//商户订单号
		String out_trade_no = request.getParameter("out_trade_no");
		//交易状态
		String trade_status = request.getParameter("trade_status");
		logger.debug("=========支付宝服务器异步通知========="+signVerified);
		if(signVerified){ // 验证成功 更新订单信息
			if(trade_status.equals("TRADE_FINISHED")){
				logger.info("TRADE_FINISHED");
			}
			if(trade_status.equals("TRADE_SUCCESS")){
				logger.info("TRADE_SUCCESS");
			}
			if(StringUtil.isNotEmpty(out_trade_no)){
				OsUser user = (OsUser) request.getSession().getAttribute("user");
		        OsOrder order = osOrderService.getByOrderNumber(Long.parseLong(out_trade_no), user.getUserId());
				//Order order=orderService.getByOrderNo(out_trade_no); // 获取订单
				if(order!=null){
					/*order.setBuyTime(new Date()); // 支付时间
					order.setIsPay(1); // 设置支付状态已经支付
					orderService.save(order);*/
					logger.debug("=========支付宝服务器异步通知更改订单测试一下=========");
					//保存订单状态
		            OsOrderStatus osOrderStatus = new OsOrderStatus();
		            osOrderStatus.setOrderId(Long.parseLong(out_trade_no));
		            osOrderStatus.setIs_pay(1);
		            osOrderStatus.setBuy_time(new Date());
		            osOrderStatus.setRemarks("订单已经支付");
		            osOrderService.updateOrderStatus(osOrderStatus);
				}
			}
		}else{
			logger.error("验证未通过");
		}
				
	} 
	
	
}
