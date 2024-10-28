package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Cate;
import com.service.CateService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/cate", produces = "text/plain;charset=utf-8")
public class CateController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private CateService cateService;

	// TODO Auto-generated method stub

	// 准备添加数据
	@RequestMapping("createCate.action")
	public String createCate() {
		return "admin/addcate";
	}

	// 添加数据
	@RequestMapping("addCate.action")
	public String addCate(Cate cate) {
		cate.setAddtime(VeDate.getStringDateShort());
		int i = this.cateService.insertCate(cate);
		this.operation("新增商品类型", i);
		return "redirect:/cate/createCate.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteCate.action")
	public String deleteCate(String id) {
		int i = this.cateService.deleteCate(id);
		this.operation("按主键删除商品类型", i);
		return "redirect:/cate/getAllCate.action";
	}

	// 批量删除数据
	@RequestMapping("deleteCateByIds.action")
	public String deleteCateByIds() {
		String[] ids = this.getRequest().getParameterValues("cateid");
		int i = 0;
		if (ids != null) {
			for (String cateid : ids) {
				i += this.cateService.deleteCate(cateid);
			}
		}
		this.operation("批量删除商品类型", i);
		return "redirect:/cate/getAllCate.action";
	}

	// 更新数据
	@RequestMapping("updateCate.action")
	public String updateCate(Cate cate) {
		int i = this.cateService.updateCate(cate);
		this.operation("修改商品类型", i);
		return "redirect:/cate/getAllCate.action";
	}

	// 显示全部数据
	@RequestMapping("getAllCate.action")
	public String getAllCate(String number) {
		List<Cate> cateList = this.cateService.getAllCate();
		PageHelper.getUserPage(cateList, "cate", "getAllCate", 10, number, this.getRequest());
		this.operation("查看商品类型数据", 1);
		return "admin/listcate";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryCateByCond.action")
	public String queryCateByCond(String cond, String name, String number) {
		Cate cate = new Cate();
		if (cond != null) {
			if ("catename".equals(cond)) {
				cate.setCatename(name);
			}
			if ("addtime".equals(cond)) {
				cate.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				cate.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.cateService.getCateByLike(cate), "cate", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querycate";
	}

	// 按主键查询数据
	@RequestMapping("getCateById.action")
	public String getCateById(String id) {
		Cate cate = this.cateService.getCateById(id);
		this.getRequest().setAttribute("cate", cate);
		return "admin/editcate";
	}

	// 按主键查询数据
	@RequestMapping("queryCateById.action")
	public String queryCateById(String id) {
		Cate cate = this.cateService.getCateById(id);
		this.getRequest().setAttribute("cate", cate);
		this.operation("查看商品类型数据", 1);
		return "admin/cate";
	}

	// TODO Auto-generated method stub

}
