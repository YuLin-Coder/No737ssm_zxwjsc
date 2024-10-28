package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 订单评价表的实体类
public class Topic {
	private String topicid = "T"+VeDate.getStringId(); // 生成主键编号
	private String usersid; // 用户
	private String ordersid; // 订单
	private String goodsid; // 商品
	private String num; // 评分
	private String contents; // 内容
	private String addtime; // 发布日期
	private String username; // 映射数据
	private String ordercode; // 映射数据
	private String goodsname; // 映射数据
	private Users users;// 多对一映射类
	private Orders orders;// 多对一映射类
	private Goods goods;// 多对一映射类

	public String getTopicid() {
		return this.topicid;
	}

	public void setTopicid(String topicid) {
		this.topicid = topicid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getOrdersid() {
		return this.ordersid;
	}

	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid;
	}

	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}


	// 重载方法 生成JSON类型字符串 
	@Override
	public String toString() {
		return this.toJsonString();
	}

	//直接转换成JSON字符串
	private String toJsonString() {
		JSONObject jsonString = new JSONObject();
		jsonString.put("topicid", this.topicid); // 主键编号
		jsonString.put("usersid", this.usersid); // 用户
		jsonString.put("ordersid", this.ordersid); // 订单
		jsonString.put("goodsid", this.goodsid); // 商品
		jsonString.put("num", this.num); // 评分
		jsonString.put("contents", this.contents); // 内容
		jsonString.put("addtime", this.addtime); // 发布日期
		jsonString.put("Users", this.users); // 多对一映射类
		jsonString.put("Orders", this.orders); // 多对一映射类
		jsonString.put("Goods", this.goods); // 多对一映射类
		jsonString.put("username", this.username); // 映射数据
		jsonString.put("ordercode", this.ordercode); // 映射数据
		jsonString.put("goodsname", this.goodsname); // 映射数据
		return jsonString.toString();
	}




}




