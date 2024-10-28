package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Cate;
import com.entity.Goods;
import com.service.CateService;
import com.service.GoodsService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/goods", produces = "text/plain;charset=utf-8")
public class GoodsController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CateService cateService;

	// TODO Auto-generated method stub

	// 准备添加数据
	@RequestMapping("createGoods.action")
	public String createGoods() {
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/addgoods";
	}

	// 添加数据
	@RequestMapping("addGoods.action")
	public String addGoods(Goods goods) {
		goods.setAddtime(VeDate.getStringDateShort());
		goods.setHits("0");
		goods.setSellnum("0");
		int i = this.goodsService.insertGoods(goods);
		this.operation("新增商品", i);
		return "redirect:/goods/createGoods.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteGoods.action")
	public String deleteGoods(String id) {
		int i = this.goodsService.deleteGoods(id);
		this.operation("按主键删除商品", i);
		return "redirect:/goods/getAllGoods.action";
	}

	// 批量删除数据
	@RequestMapping("deleteGoodsByIds.action")
	public String deleteGoodsByIds() {
		String[] ids = this.getRequest().getParameterValues("goodsid");
		int i = 0;
		if (ids != null) {
			for (String goodsid : ids) {
				i += this.goodsService.deleteGoods(goodsid);
			}
		}
		this.operation("批量删除商品", i);
		return "redirect:/goods/getAllGoods.action";
	}

	// 更新数据
	@RequestMapping("updateGoods.action")
	public String updateGoods(Goods goods) {
		int i = this.goodsService.updateGoods(goods);
		this.operation("修改商品", i);
		return "redirect:/goods/getAllGoods.action";
	}

	// 显示全部数据
	@RequestMapping("getAllGoods.action")
	public String getAllGoods(String number) {
		List<Goods> goodsList = this.goodsService.getAllGoods();
		PageHelper.getUserPage(goodsList, "goods", "getAllGoods", 10, number, this.getRequest());
		this.operation("查看商品数据", 1);
		return "admin/listgoods";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryGoodsByCond.action")
	public String queryGoodsByCond(String cond, String name, String number) {
		Goods goods = new Goods();
		if (cond != null) {
			if ("goodsname".equals(cond)) {
				goods.setGoodsname(name);
			}
			if ("image".equals(cond)) {
				goods.setImage(name);
			}
			if ("cateid".equals(cond)) {
				goods.setCateid(name);
			}
			if ("price".equals(cond)) {
				goods.setPrice(name);
			}
			if ("recommend".equals(cond)) {
				goods.setRecommend(name);
			}
			if ("special".equals(cond)) {
				goods.setSpecial(name);
			}
			if ("storage".equals(cond)) {
				goods.setStorage(name);
			}
			if ("addtime".equals(cond)) {
				goods.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				goods.setHits(name);
			}
			if ("sellnum".equals(cond)) {
				goods.setSellnum(name);
			}
			if ("contents".equals(cond)) {
				goods.setContents(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.goodsService.getGoodsByLike(goods), "goods", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querygoods";
	}

	// 按主键查询数据
	@RequestMapping("getGoodsById.action")
	public String getGoodsById(String id) {
		Goods goods = this.goodsService.getGoodsById(id);
		this.getRequest().setAttribute("goods", goods);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/editgoods";
	}

	// 按主键查询数据
	@RequestMapping("queryGoodsById.action")
	public String queryGoodsById(String id) {
		Goods goods = this.goodsService.getGoodsById(id);
		this.getRequest().setAttribute("goods", goods);
		this.operation("查看商品数据", 1);
		return "admin/goods";
	}

	// TODO Auto-generated method stub

}
