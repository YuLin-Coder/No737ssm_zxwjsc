package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 订单明细表的实体类
public class Details {
	private String detailsid = "D"+VeDate.getStringId(); // 生成主键编号
	private String ordercode; // 订单号
	private String goodsid; // 商品
	private String price; // 单价
	private String num; // 数量
	private String goodsname; // 映射数据
	private Goods goods;// 多对一映射类

	public String getDetailsid() {
		return this.detailsid;
	}

	public void setDetailsid(String detailsid) {
		this.detailsid = detailsid;
	}

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
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

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
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
		jsonString.put("detailsid", this.detailsid); // 主键编号
		jsonString.put("ordercode", this.ordercode); // 订单号
		jsonString.put("goodsid", this.goodsid); // 商品
		jsonString.put("price", this.price); // 单价
		jsonString.put("num", this.num); // 数量
		jsonString.put("Goods", this.goods); // 多对一映射类
		jsonString.put("goodsname", this.goodsname); // 映射数据
		return jsonString.toString();
	}




}




