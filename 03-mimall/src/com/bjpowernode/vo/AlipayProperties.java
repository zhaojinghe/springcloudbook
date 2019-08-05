package com.bjpowernode.vo;
/**
 * 支付宝支付配置文件
 * @author Administrator
 * * #支付宝支付配置
 *# APPID 商户appid 
 * # RSA_PRIVATE_KEY 私钥 pkcs8格式的
 *# notify_url 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
 *# return_url 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
 * # URL 请求网关地址
 * # CHARSET 编码
 *# FORMAT 返回格式
 *# ALIPAY_PUBLIC_KEY 支付宝公钥
 *# SIGNTYPE RSA2
 */

public class AlipayProperties {

	private String appid="2016101000651749"; // 商户appid
	
	private String rsa_private_key="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCfHmP/yUw/wOTJX7vBsTh/dmWXcfzdSXD7QPnIX/IrhZV72z7eOya62SO2A5tuGtZrZNMpxEFqEg8I701Jp/Ps2yzP1MzKzy9NS2airIzJEm5kutMktIchOEZP89khntWDjWDlFpQCRdBhH7rkO78WtWam2J++KbqXrAeYYFcLjAFn6gSEAJFZQNZgYIaK4fu8h68Zb1mM5Ols1mF1NF7C2zuPTOmjalEMXt42PKbjjp2iaoaMKF6yYLumMehBoLRuoBZ5POXVIxJixwj+KSe4AwLGIc6G78O1yDc+2LJJAxn+j0IEgADfGJj8tHmd/kvzto075ZGKj6CRGuhdECnjAgMBAAECggEAXhqUG4eKb7390NasbR4JguCbrph8asbvabkAwK91wqWLRafho36qJiEbTJ8Pgmue2f7UH8Rwx3GMsMUOGXyZ9z+cXgHFaEBmAjmQpq6TyKr83Nfc3b1imZP1iX12sbqFHfs0DehvenSdi4M/fZGULrLz1cMRnl6BewgDqet4L1wbL1JWylsImc04Gd4GKLiibAi6XzCPIMGPUvlez8IsTSRRUUiCZf+5J1WIseeqwtIZXrXbl8k4F1Zha9OO0ylf0ONF79woiGWr2wCOgRDp7J36yMVaklP+RY14/7/yQKUIG0amqGiX2A7zlcrXmF0EHaLMF/qxgRV9IQ3iJ5SaqQKBgQDb/gSDG86q889vEn3oEjJqgVdTYaPwgNlsR4Azytf0zz4FuYNIVwibYgg3iXCINOTy5birrNgjiRj8c7JoFJXBLJVTW5sp/WqFtXH7avwu8U+nuqP32fh9+qV0DisMhCnSQeUXQkAsBArKDR92KGi2zBKRg/cIORAj5N1AVFSiBQKBgQC5Ka/HxW5cl6Q8UaEf3ruvtxApyQpcFgv6Ij9fffuPGHjY4VB4uJN2pcG5I7JZhAJWMgXjKEC0KN/OjxX+/FElvoY6ozBuL1qFLsJtV5OlMayrN48EBUAHN+yXhgi1ovvEIcfvklyuGa7g0txvwI8t5wgmDQY7TXMAltjxdurYxwKBgQClmkRfRbF/cuV14V+yMPCOyCqqc9frFbOWFQTm+A01FkTEHnA7JnkuLs+sruNtRRQL3O31Hbneljee4qEsREKvFhaal1zocQGdAYd6EYEg/TpPMup3izfJ7cJa6MdzNpIc2snPhmm0OJ6+lr5WPfkFkf1wWPy+zeXef0wmPtUu2QKBgFMqgiV8bAFyqvXcxD4IUMyvsLbT8a9Cx8Zls4k0kNTI7R6ctQREAxf7g3OgsO67+EC23yYUYluJMF0ar4qD0f7eAHQ97/bNlh7TzchG2a4NDb0pizcHFKcpWz8DmM3ckrCZa7ATUUVxi7a3fwNCvgykBGjy2KWyN8E//9kUzI7pAoGBAKMoeZAPMbH6BUPLE614F2ZTyl8MDgPDPAnfWQuV8XdtMeTiPi7aMiEqKPgE0GFAL6T+b0Z1JF6aTLfpTdI7Mz4/4xIafYXV153usMtxDALX4RxkkNprwgZNawogT4Xj4p03hClIWd5aYcZBkttmTOeMH59n0xGHdj9JPc7BKPHI"; // 私钥 pkcs8格式的
	
	private String notify_url="http://localhost:8888/mimall/alipay/notifyUrl"; // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	
	private String return_url="http://localhost:8888/mimall/alipay/returnUrl"; // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	
	private String url="https://openapi.alipaydev.com/gateway.do"; // 请求网关地址
	
	private String charset="UTF-8"; // 编码
	
	private String format="json"; // 返回格式
	
	private String alipay_public_key="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnx5j/8lMP8DkyV+7wbE4f3Zll3H83Ulw+0D5yF/yK4WVe9s+3jsmutkjtgObbhrWa2TTKcRBahIPCO9NSafz7Nssz9TMys8vTUtmoqyMyRJuZLrTJLSHIThGT/PZIZ7Vg41g5RaUAkXQYR+65Du/FrVmptifvim6l6wHmGBXC4wBZ+oEhACRWUDWYGCGiuH7vIevGW9ZjOTpbNZhdTRewts7j0zpo2pRDF7eNjym446domqGjChesmC7pjHoQaC0bqAWeTzl1SMSYscI/iknuAMCxiHOhu/Dtcg3PtiySQMZ/o9CBIAA3xiY/LR5nf5L87aNO+WRio+gkRroXRAp4wIDAQAB"; // 支付宝公钥
	
	private String signtype="RSA2";  // RSA2

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getRsa_private_key() {
		return rsa_private_key;
	}

	public void setRsa_private_key(String rsa_private_key) {
		this.rsa_private_key = rsa_private_key;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getReturn_url() {
		return return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getAlipay_public_key() {
		return alipay_public_key;
	}

	public void setAlipay_public_key(String alipay_public_key) {
		this.alipay_public_key = alipay_public_key;
	}

	public String getSigntype() {
		return signtype;
	}

	public void setSigntype(String signtype) {
		this.signtype = signtype;
	}

	@Override
	public String toString() {
		return "AlipayProperties [appid=" + appid + ", rsa_private_key=" + rsa_private_key + ", notify_url="
				+ notify_url + ", return_url=" + return_url + ", url=" + url + ", charset=" + charset + ", format="
				+ format + ", alipay_public_key=" + alipay_public_key + ", signtype=" + signtype + "]";
	}
	
	
	
	
}
