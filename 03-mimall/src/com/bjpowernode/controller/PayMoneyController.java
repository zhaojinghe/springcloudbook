package com.bjpowernode.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PayMoneyController {
	
	
	@RequestMapping("/payali")
	public String pay(@RequestParam("trade_no")String trade_no,
			@RequestParam("totalmoney")BigDecimal totalmoney,Model model){
		
		System.out.println("=========trade_no========="+trade_no);
		System.out.println("=========totalmoney========="+totalmoney);
		model.addAttribute("trade_no", trade_no);
		model.addAttribute("totalmoney", totalmoney);
		
		return "/pay/index";
	}

	@RequestMapping("/paymoney")
	public String paymoney(@RequestParam("WIDout_trade_no")String WIDout_trade_no,
			@RequestParam("WIDtotal_amount")String WIDtotal_amount,
			@RequestParam("WIDsubject")String WIDsubject,
			@RequestParam("WIDbody")String WIDbody,Model model,
			HttpServletRequest request){
		
	
		
		model.addAttribute("WIDout_trade_no", WIDout_trade_no);
		
		model.addAttribute("WIDtotal_amount", WIDtotal_amount);
		model.addAttribute("WIDsubject",WIDsubject);
		model.addAttribute("WIDbody", WIDbody);
		System.out.println("=========WIDout_trade_no========="+WIDout_trade_no);
		System.out.println("=========WIDtotal_amount========="+WIDtotal_amount);
		System.out.println("========///////////////====="+WIDtotal_amount);
		return "/pay/alipay.trade.page.pay";
	}
}
