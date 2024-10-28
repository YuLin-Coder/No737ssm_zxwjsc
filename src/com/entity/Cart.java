package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 购物车表的实体类
public class Cart {
	private String cartid = "C"+VeDate.getStringId(); // 生成主键编号
	private String usersid; // 用户
	private String goodsid; // 商品
	private String price; // 单价
	private String num; // 数量
	private String addtime; // 加入日期
	private String username; // 映射数据
	private String goodsname; // 映射数据
	private Users users;// 多对一映射类
	private Goods goods;// 多对一映射类

	public String getCartid() {
		return this.cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
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
		jsonString.put("cartid", this.cartid); // 主键编号
		jsonString.put("usersid", this.usersid); // 用户
		jsonString.put("goodsid", this.goodsid); // 商品
		jsonString.put("price", this.price); // 单价
		jsonString.put("num", this.num); // 数量
		jsonString.put("addtime", this.addtime); // 加入日期
		jsonString.put("Users", this.users); // 多对一映射类
		jsonString.put("Goods", this.goods); // 多对一映射类
		jsonString.put("username", this.username); // 映射数据
		jsonString.put("goodsname", this.goodsname); // 映射数据
		return jsonString.toString();
	}




}




