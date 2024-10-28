package com.entity;

import com.util.VeDate;
import com.alibaba.fastjson.JSONObject;

// 新闻公告表的实体类
public class Article {
	private String articleid = "A"+VeDate.getStringId(); // 生成主键编号
	private String title; // 标题
	private String image; // 图片
	private String contents; // 内容
	private String addtime; // 发布日期
	private String hits; // 点击数

	public String getArticleid() {
		return this.articleid;
	}

	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getHits() {
		return this.hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}


	// 重载方法 生成JSON类型字符串 
	@Override
	public String toString() {
		return this.toJsonString();
	}

	//直接转换成JSON字符串
	private String toJsonString() {
		JSONObject jsonString = new JSONObject();
		jsonString.put("articleid", this.articleid); // 主键编号
		jsonString.put("title", this.title); // 标题
		jsonString.put("image", this.image); // 图片
		jsonString.put("contents", this.contents); // 内容
		jsonString.put("addtime", this.addtime); // 发布日期
		jsonString.put("hits", this.hits); // 点击数
		return jsonString.toString();
	}




}




