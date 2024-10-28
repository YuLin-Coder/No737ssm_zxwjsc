package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 订单表的实体类
public class Orders {
	private String ordersid = "O"+VeDate.getStringId(); // 生成主键编号
	private String ordercode; // 订单号
	private String usersid; // 用户
	private String total; // 总计
	private String status; // 状态
	private String addtime; // 下单日期
	private String receiver; // 收货人
	private String address; // 送货地址
	private String contact; // 联系方式
	private String username; // 映射数据
	private Users users;// 多对一映射类

	public String getOrdersid() {
		return this.ordersid;
	}

	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid;
	}

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	// 重载方法 生成JSON类型字符串 
	@Override
	public String toString() {
		return this.toJsonString();
	}

	//直接转换成JSON字符串
	private String toJsonString() {
		JSONObject jsonString = new JSONObject();
		jsonString.put("ordersid", this.ordersid); // 主键编号
		jsonString.put("ordercode", this.ordercode); // 订单号
		jsonString.put("usersid", this.usersid); // 用户
		jsonString.put("total", this.total); // 总计
		jsonString.put("status", this.status); // 状态
		jsonString.put("addtime", this.addtime); // 下单日期
		jsonString.put("receiver", this.receiver); // 收货人
		jsonString.put("address", this.address); // 送货地址
		jsonString.put("contact", this.contact); // 联系方式
		jsonString.put("Users", this.users); // 多对一映射类
		jsonString.put("username", this.username); // 映射数据
		return jsonString.toString();
	}




}




