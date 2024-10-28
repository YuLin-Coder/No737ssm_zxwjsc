package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 商品表的实体类
public class Goods {
	private String goodsid = "G"+VeDate.getStringId(); // 生成主键编号
	private String goodsname; // 商品名称
	private String image; // 商品图片
	private String cateid; // 商品类型
	private String price; // 商品价格
	private String recommend; // 是否推荐
	private String special; // 是否特价
	private String storage; // 库存数量
	private String addtime; // 上架日期
	private String hits; // 点击数
	private String sellnum; // 销售数
	private String contents; // 商品详情
	private String catename; // 映射数据
	private Cate cate;// 多对一映射类

	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCateid() {
		return this.cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRecommend() {
		return this.recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getSpecial() {
		return this.special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getStorage() {
		return this.storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getHits() {
		return this.hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	public String getSellnum() {
		return this.sellnum;
	}

	public void setSellnum(String sellnum) {
		this.sellnum = sellnum;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Cate getCate() {
		return this.cate;
	}

	public void setCate(Cate cate) {
		this.cate = cate;
	}

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}


	// 重载方法 生成JSON类型字符串 
	@Override
	public String toString() {
		return this.toJsonString();
	}

	//直接转换成JSON字符串
	private String toJsonString() {
		JSONObject jsonString = new JSONObject();
		jsonString.put("goodsid", this.goodsid); // 主键编号
		jsonString.put("goodsname", this.goodsname); // 商品名称
		jsonString.put("image", this.image); // 商品图片
		jsonString.put("cateid", this.cateid); // 商品类型
		jsonString.put("price", this.price); // 商品价格
		jsonString.put("recommend", this.recommend); // 是否推荐
		jsonString.put("special", this.special); // 是否特价
		jsonString.put("storage", this.storage); // 库存数量
		jsonString.put("addtime", this.addtime); // 上架日期
		jsonString.put("hits", this.hits); // 点击数
		jsonString.put("sellnum", this.sellnum); // 销售数
		jsonString.put("contents", this.contents); // 商品详情
		jsonString.put("Cate", this.cate); // 多对一映射类
		jsonString.put("catename", this.catename); // 映射数据
		return jsonString.toString();
	}




}




